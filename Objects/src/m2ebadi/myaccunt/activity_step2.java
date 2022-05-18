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

public class activity_step2 extends Activity implements B4AActivity{
	public static activity_step2 mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "m2ebadi.myaccunt", "m2ebadi.myaccunt.activity_step2");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (activity_step2).");
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
		activityBA = new BA(this, layout, processBA, "m2ebadi.myaccunt", "m2ebadi.myaccunt.activity_step2");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "m2ebadi.myaccunt.activity_step2", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (activity_step2) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (activity_step2) Resume **");
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
		return activity_step2.class;
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
            BA.LogInfo("** Activity (activity_step2) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (activity_step2) Pause event (activity is not paused). **");
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
            activity_step2 mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (activity_step2) Resume **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _pan_all_edit = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_email = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_namefamili = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_noske = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_namefamili = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_email = null;
public m2ebadi.myaccunt.httpjob _ht1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_phonenum = null;
public m2ebadi.myaccunt.main _main = null;
public m2ebadi.myaccunt.starter _starter = null;
public m2ebadi.myaccunt.activity_step1 _activity_step1 = null;
public m2ebadi.myaccunt.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Activity.LoadLayout(\"step2\")";
mostCurrent._activity.LoadLayout("step2",mostCurrent.activityBA);
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum"))) { 
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
mostCurrent._main._phon_num /*String*/  = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum");
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
 }else {
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="ht1.Initialize(\"ht1\",Me)";
mostCurrent._ht1._initialize /*String*/ (null,processBA,"ht1",activity_step2.getObject());
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="send = \"var=3&phone=\"&Main.phon_num&\"";
_send = "var=3&phone="+mostCurrent._main._phon_num /*String*/ +"";
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="ht1.PostString(\"https://taravatgroup.ir/save_acc";
mostCurrent._ht1._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }else 
{RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="Else If(type1=2)Then ' to edit";
if ((_type1==2)) { 
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="ht1.Initialize(\"ht2\",Me)";
mostCurrent._ht1._initialize /*String*/ (null,processBA,"ht2",activity_step2.getObject());
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="send = \"var=2&name=\"&et_nameFamili.Text&\"&email=";
_send = "var=2&name="+mostCurrent._et_namefamili.getText()+"&email="+mostCurrent._et_email.getText()+"&phone="+mostCurrent._main._phon_num /*String*/ +"";
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="ht1.PostString(\"https://taravatgroup.ir/save_acc";
mostCurrent._ht1._poststring /*String*/ (null,"https://taravatgroup.ir/save_acc.php",_send);
 }}
;
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="activity_step2";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(m2ebadi.myaccunt.httpjob _job) throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String[] _a = null;
anywheresoftware.b4a.objects.collections.List _ls_user = null;
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("44784129",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
if ((_job._getstring /*String*/ (null).contains("nouser"))) { 
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="Log (\"account not exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("44784134","account not exist",0);
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="lbl_logOff_Click";
_lbl_logoff_click();
 }else {
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="Dim a() As String";
_a = new String[(int) (0)];
java.util.Arrays.fill(_a,"");
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
_a = anywheresoftware.b4a.keywords.Common.Regex.Split("&",_job._getstring /*String*/ (null));
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="lbl_nameFamili.Text=a(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_a[(int) (0)]));
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="lbl_email.Text=a(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_a[(int) (1)]));
RDebugUtils.currentLine=4784144;
 //BA.debugLineNum = 4784144;BA.debugLine="If(a(2)=1)Then";
if (((_a[(int) (2)]).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=4784145;
 //BA.debugLineNum = 4784145;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
RDebugUtils.currentLine=4784147;
 //BA.debugLineNum = 4784147;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 };
RDebugUtils.currentLine=4784150;
 //BA.debugLineNum = 4784150;BA.debugLine="lbl_phoneNum.Text=a(3)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_a[(int) (3)]));
RDebugUtils.currentLine=4784152;
 //BA.debugLineNum = 4784152;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc",anywheresoftware.b4a.keywords.Common.ArrayToList(_a));
 };
 };
RDebugUtils.currentLine=4784157;
 //BA.debugLineNum = 4784157;BA.debugLine="If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=4784158;
 //BA.debugLineNum = 4784158;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
if ((_job._getstring /*String*/ (null).contains("true"))) { 
RDebugUtils.currentLine=4784159;
 //BA.debugLineNum = 4784159;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=4784160;
 //BA.debugLineNum = 4784160;BA.debugLine="lbl_back_Click";
_lbl_back_click();
RDebugUtils.currentLine=4784161;
 //BA.debugLineNum = 4784161;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("تغییرات ذخیره شد"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 }else {
RDebugUtils.currentLine=4784168;
 //BA.debugLineNum = 4784168;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True)";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4784170;
 //BA.debugLineNum = 4784170;BA.debugLine="Dim ls_user As List";
_ls_user = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4784171;
 //BA.debugLineNum = 4784171;BA.debugLine="ls_user.Initialize";
_ls_user.Initialize();
RDebugUtils.currentLine=4784172;
 //BA.debugLineNum = 4784172;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc";
_ls_user = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=4784174;
 //BA.debugLineNum = 4784174;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
mostCurrent._lbl_namefamili.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (0))));
RDebugUtils.currentLine=4784175;
 //BA.debugLineNum = 4784175;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
mostCurrent._lbl_email.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (1))));
RDebugUtils.currentLine=4784177;
 //BA.debugLineNum = 4784177;BA.debugLine="If(ls_user.Get(2)=\"1\")Then";
if (((_ls_user.Get((int) (2))).equals((Object)("1")))) { 
RDebugUtils.currentLine=4784178;
 //BA.debugLineNum = 4784178;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
RDebugUtils.currentLine=4784180;
 //BA.debugLineNum = 4784180;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
mostCurrent._lbl_noske.setText(BA.ObjectToCharSequence("نسخه طلایی"));
 };
RDebugUtils.currentLine=4784183;
 //BA.debugLineNum = 4784183;BA.debugLine="lbl_phoneNum.Text=ls_user.Get(3)";
mostCurrent._lbl_phonenum.setText(BA.ObjectToCharSequence(_ls_user.Get((int) (3))));
 };
 };
RDebugUtils.currentLine=4784191;
 //BA.debugLineNum = 4784191;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_logoff_click() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_logoff_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_logoff_click", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Private Sub lbl_logOff_Click";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc");
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_click() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_click", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub lbl_back_Click";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="pan_all_edit.Visible=False";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_edit_click() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_edit_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Private Sub lbl_edit_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
mostCurrent._et_namefamili.setText(BA.ObjectToCharSequence(mostCurrent._lbl_namefamili.getText()));
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="et_email.Text=lbl_email.Text";
mostCurrent._et_email.setText(BA.ObjectToCharSequence(mostCurrent._lbl_email.getText()));
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="pan_all_edit.Visible=True";
mostCurrent._pan_all_edit.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_save_edit_click() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_save_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_save_edit_click", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Private Sub lbl_save_edit_Click";
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_edit_click() throws Exception{
RDebugUtils.currentModule="activity_step2";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_edit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_edit_click", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Private Sub pan_all_edit_Click";
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="End Sub";
return "";
}
}