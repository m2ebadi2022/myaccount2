package m2ebadi.myaccunt;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "m2ebadi.myaccunt", "m2ebadi.myaccunt.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "m2ebadi.myaccunt", "m2ebadi.myaccunt.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "m2ebadi.myaccunt.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _time_remind = null;
public static String _phon_num = "";
public anywheresoftware.b4a.objects.EditTextWrapper _et_phonnum = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_code_num = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_send = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_run2_step0 = null;
public m2ebadi.myaccunt.httpjob _ht = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_time_remind = null;
public static int _min1 = 0;
public static int _sec1 = 0;
public m2ebadi.myaccunt.starter _starter = null;
public m2ebadi.myaccunt.activity_step1 _activity_step1 = null;
public m2ebadi.myaccunt.activity_step2 _activity_step2 = null;
public m2ebadi.myaccunt.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (activity_step1.mostCurrent != null);
vis = vis | (activity_step2.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 40;BA.debugLine="If (File.Exists(File.DirInternal,\"userAcc\")=True)";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 41;BA.debugLine="StartActivity(activity_step2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step2.getObject()));
 //BA.debugLineNum = 42;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"step0\")";
mostCurrent._activity.LoadLayout("step0",mostCurrent.activityBA);
 //BA.debugLineNum = 45;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
_time_remind.Initialize(processBA,"time_remind",(long) (1000));
 };
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _et_code_num_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
 //BA.debugLineNum = 157;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private et_phonNum As EditText";
mostCurrent._et_phonnum = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private et_code_num As EditText";
mostCurrent._et_code_num = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pan_all_send As Panel";
mostCurrent._pan_all_send = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lbl_run2_step0 As Label";
mostCurrent._lbl_run2_step0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim ht As HttpJob";
mostCurrent._ht = new m2ebadi.myaccunt.httpjob();
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_time_remind As Label";
mostCurrent._lbl_time_remind = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim min1 As Int=14";
_min1 = (int) (14);
 //BA.debugLineNum = 33;BA.debugLine="Dim sec1 As Int=59";
_sec1 = (int) (59);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
String _send = "";
 //BA.debugLineNum = 162;BA.debugLine="Sub http_initial_1(type1 As Int)";
 //BA.debugLineNum = 164;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
 //BA.debugLineNum = 165;BA.debugLine="ht.Initialize(\"ht1\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht1",main.getObject());
 //BA.debugLineNum = 166;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 167;BA.debugLine="send = \"id=1&num=\"&phon_num&\"&code=0\"";
_send = "id=1&num="+_phon_num+"&code=0";
 //BA.debugLineNum = 168;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/sms_req.php",_send);
 }else if((_type1==2)) { 
 //BA.debugLineNum = 172;BA.debugLine="ht.Initialize(\"ht2\",Me)";
mostCurrent._ht._initialize /*String*/ (processBA,"ht2",main.getObject());
 //BA.debugLineNum = 173;BA.debugLine="Dim send As String";
_send = "";
 //BA.debugLineNum = 174;BA.debugLine="send = \"id=2&num=\"&phon_num&\"&code=\"&et_code_num";
_send = "id=2&num="+_phon_num+"&code="+mostCurrent._et_code_num.getText();
 //BA.debugLineNum = 175;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
mostCurrent._ht._poststring /*String*/ ("https://taravatgroup.ir/sms_req.php",_send);
 };
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(m2ebadi.myaccunt.httpjob _job) throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Sub Jobdone (job As HttpJob)";
 //BA.debugLineNum = 185;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 186;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("4786434",_job._getstring /*String*/ (),0);
 //BA.debugLineNum = 187;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
 };
 //BA.debugLineNum = 192;BA.debugLine="If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
 //BA.debugLineNum = 193;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
if ((_job._getstring /*String*/ ().contains("okuser")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 194;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",ph";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",_phon_num);
 //BA.debugLineNum = 195;BA.debugLine="StartActivity(activity_step2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step2.getObject()));
 }else if((_job._getstring /*String*/ ().contains("nouser")==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 200;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",ph";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",_phon_num);
 //BA.debugLineNum = 201;BA.debugLine="StartActivity(activity_step1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step1.getObject()));
 }else {
 //BA.debugLineNum = 203;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 }else {
 };
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_run1_click() throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Private Sub lbl_back_run1_Click";
 //BA.debugLineNum = 153;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run1_step0_click() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub lbl_run1_step0_Click";
 //BA.debugLineNum = 128;BA.debugLine="phon_num=et_phonNum.Text";
_phon_num = mostCurrent._et_phonnum.getText();
 //BA.debugLineNum = 129;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 //BA.debugLineNum = 130;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 131;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="time_remind.Enabled=True";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run2_step0_click() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Private Sub lbl_run2_step0_Click";
 //BA.debugLineNum = 138;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_send_click() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Private Sub pan_all_send_Click";
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
activity_step1._process_globals();
activity_step2._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim time_remind As Timer";
_time_remind = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 19;BA.debugLine="Dim phon_num As String";
_phon_num = "";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _time_remind_tick() throws Exception{
String _sec2 = "";
String _min2 = "";
 //BA.debugLineNum = 49;BA.debugLine="Sub time_remind_Tick";
 //BA.debugLineNum = 51;BA.debugLine="If(min1<1 And sec1<1)Then";
if ((_min1<1 && _sec1<1)) { 
 //BA.debugLineNum = 52;BA.debugLine="time_remind.Enabled=False";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 53;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("0:0"));
 };
 //BA.debugLineNum = 56;BA.debugLine="Dim sec2 As String=sec1";
_sec2 = BA.NumberToString(_sec1);
 //BA.debugLineNum = 57;BA.debugLine="Dim min2 As String=min1";
_min2 = BA.NumberToString(_min1);
 //BA.debugLineNum = 58;BA.debugLine="Select sec2";
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 //BA.debugLineNum = 60;BA.debugLine="sec2=\"00\"";
_sec2 = "00";
 break; }
case 1: {
 //BA.debugLineNum = 62;BA.debugLine="sec2=\"01\"";
_sec2 = "01";
 break; }
case 2: {
 //BA.debugLineNum = 64;BA.debugLine="sec2=\"02\"";
_sec2 = "02";
 break; }
case 3: {
 //BA.debugLineNum = 66;BA.debugLine="sec2=\"03\"";
_sec2 = "03";
 break; }
case 4: {
 //BA.debugLineNum = 68;BA.debugLine="sec2=\"04\"";
_sec2 = "04";
 break; }
case 5: {
 //BA.debugLineNum = 70;BA.debugLine="sec2=\"05\"";
_sec2 = "05";
 break; }
case 6: {
 //BA.debugLineNum = 72;BA.debugLine="sec2=\"06\"";
_sec2 = "06";
 break; }
case 7: {
 //BA.debugLineNum = 74;BA.debugLine="sec2=\"07\"";
_sec2 = "07";
 break; }
case 8: {
 //BA.debugLineNum = 76;BA.debugLine="sec2=\"08\"";
_sec2 = "08";
 break; }
case 9: {
 //BA.debugLineNum = 78;BA.debugLine="sec2=\"09\"";
_sec2 = "09";
 break; }
}
;
 //BA.debugLineNum = 80;BA.debugLine="Select min2";
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 //BA.debugLineNum = 82;BA.debugLine="min2=\"00\"";
_min2 = "00";
 break; }
case 1: {
 //BA.debugLineNum = 84;BA.debugLine="min2=\"01\"";
_min2 = "01";
 break; }
case 2: {
 //BA.debugLineNum = 86;BA.debugLine="min2=\"02\"";
_min2 = "02";
 break; }
case 3: {
 //BA.debugLineNum = 88;BA.debugLine="min2=\"03\"";
_min2 = "03";
 break; }
case 4: {
 //BA.debugLineNum = 90;BA.debugLine="min2=\"04\"";
_min2 = "04";
 break; }
case 5: {
 //BA.debugLineNum = 92;BA.debugLine="min2=\"05\"";
_min2 = "05";
 break; }
case 6: {
 //BA.debugLineNum = 94;BA.debugLine="min2=\"06\"";
_min2 = "06";
 break; }
case 7: {
 //BA.debugLineNum = 96;BA.debugLine="min2=\"07\"";
_min2 = "07";
 break; }
case 8: {
 //BA.debugLineNum = 98;BA.debugLine="min2=\"08\"";
_min2 = "08";
 break; }
case 9: {
 //BA.debugLineNum = 100;BA.debugLine="min2=\"09\"";
_min2 = "09";
 break; }
}
;
 //BA.debugLineNum = 103;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence(_min2+":"+_sec2));
 //BA.debugLineNum = 105;BA.debugLine="If(sec1<1)Then";
if ((_sec1<1)) { 
 //BA.debugLineNum = 106;BA.debugLine="min1=min1-1";
_min1 = (int) (_min1-1);
 //BA.debugLineNum = 107;BA.debugLine="sec1=60";
_sec1 = (int) (60);
 };
 //BA.debugLineNum = 110;BA.debugLine="sec1=sec1-1";
_sec1 = (int) (_sec1-1);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
}
