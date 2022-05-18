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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "m2ebadi.myaccunt", "m2ebadi.myaccunt.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (activity_step1.mostCurrent != null);
vis = vis | (activity_step2.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (activity_step1.previousOne != null) {
				__a = activity_step1.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(activity_step1.mostCurrent == null ? null : activity_step1.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (activity_step2.previousOne != null) {
				__a = activity_step2.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(activity_step2.mostCurrent == null ? null : activity_step2.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_run1_step0 = null;
public m2ebadi.myaccunt.starter _starter = null;
public m2ebadi.myaccunt.activity_step1 _activity_step1 = null;
public m2ebadi.myaccunt.activity_step2 _activity_step2 = null;
public m2ebadi.myaccunt.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="If (File.Exists(File.DirInternal,\"userAcc\")=True)";
if ((anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"userAcc")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="StartActivity(activity_step2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step2.getObject()));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.LoadLayout(\"step0\")";
mostCurrent._activity.LoadLayout("step0",mostCurrent.activityBA);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
_time_remind.Initialize(processBA,"time_remind",(long) (1000));
 };
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="et_phonNum.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_phonnum.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="et_code_num.Color=Colors.ARGB(0,0,0,0)";
mostCurrent._et_code_num.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _et_code_num_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_code_num_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_code_num_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="lbl_run2_step0.Enabled=True";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="End Sub";
return "";
}
public static String  _et_phonnum_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "et_phonnum_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "et_phonnum_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Private Sub et_phonNum_TextChanged (Old As String,";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="lbl_run1_step0.Enabled=False";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="lbl_run1_step0.Enabled=True";
mostCurrent._lbl_run1_step0.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="End Sub";
return "";
}
public static String  _http_initial_1(int _type1) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "http_initial_1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "http_initial_1", new Object[] {_type1}));}
String _send = "";
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub http_initial_1(type1 As Int)";
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="If(type1=1)Then";
if ((_type1==1)) { 
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="ht.Initialize(\"ht1\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht1",main.getObject());
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="send = \"id=1&num=\"&phon_num&\"&code=0\"";
_send = "id=1&num="+_phon_num+"&code=0";
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/sms_req.php",_send);
 }else 
{RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Else if (type1=2)Then";
if ((_type1==2)) { 
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="ht.Initialize(\"ht2\",Me)";
mostCurrent._ht._initialize /*String*/ (null,processBA,"ht2",main.getObject());
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="Dim send As String";
_send = "";
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="send = \"id=2&num=\"&phon_num&\"&code=\"&et_code_num";
_send = "id=2&num="+_phon_num+"&code="+mostCurrent._et_code_num.getText();
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
mostCurrent._ht._poststring /*String*/ (null,"https://taravatgroup.ir/sms_req.php",_send);
 }}
;
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(m2ebadi.myaccunt.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Jobdone (job As HttpJob)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("44390914",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="If job.JobName=\"ht1\" Then";
if ((_job._jobname /*String*/ ).equals("ht1")) { 
 };
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="If job.JobName=\"ht2\" Then";
if ((_job._jobname /*String*/ ).equals("ht2")) { 
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
if ((_job._getstring /*String*/ (null).contains("okuser")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",ph";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",_phon_num);
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="StartActivity(activity_step2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step2.getObject()));
 }else 
{RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="Else if (job.GetString.Contains(\"nouser\")=True)";
if ((_job._getstring /*String*/ (null).contains("nouser")==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4390928;
 //BA.debugLineNum = 4390928;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",ph";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"phonNum",_phon_num);
RDebugUtils.currentLine=4390929;
 //BA.debugLineNum = 4390929;BA.debugLine="StartActivity(activity_step1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._activity_step1.getObject()));
 }else {
RDebugUtils.currentLine=4390931;
 //BA.debugLineNum = 4390931;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید اشتباه است"),anywheresoftware.b4a.keywords.Common.False);
 }}
;
 };
 }else {
 };
RDebugUtils.currentLine=4390940;
 //BA.debugLineNum = 4390940;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_back_run1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_back_run1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_back_run1_click", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Private Sub lbl_back_run1_Click";
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="pan_all_send.Visible=False";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run1_step0_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run1_step0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run1_step0_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub lbl_run1_step0_Click";
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="If(et_phonNum.Text=\"\")Then";
if (((mostCurrent._et_phonnum.getText()).equals(""))) { 
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="ToastMessageShow(\"شماره مبایل معتبر وارد کنید\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("شماره مبایل معتبر وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="phon_num=et_phonNum.Text";
_phon_num = mostCurrent._et_phonnum.getText();
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="http_initial_1(1)";
_http_initial_1((int) (1));
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="lbl_run2_step0.Enabled=False";
mostCurrent._lbl_run2_step0.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="pan_all_send.Visible=True";
mostCurrent._pan_all_send.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="time_remind.Enabled=True";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="End Sub";
return "";
}
public static String  _lbl_run2_step0_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbl_run2_step0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbl_run2_step0_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub lbl_run2_step0_Click";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="If(et_code_num.Text=\"\")Then";
if (((mostCurrent._et_code_num.getText()).equals(""))) { 
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="ToastMessageShow(\"کد تائید را وارد کنید\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کد تائید را وارد کنید"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="http_initial_1(2)";
_http_initial_1((int) (2));
 };
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="End Sub";
return "";
}
public static String  _pan_all_send_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pan_all_send_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pan_all_send_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub pan_all_send_Click";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="End Sub";
return "";
}
public static String  _time_remind_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_remind_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time_remind_tick", null));}
String _sec2 = "";
String _min2 = "";
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub time_remind_Tick";
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="If(min1<1 And sec1<1)Then";
if ((_min1<1 && _sec1<1)) { 
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="time_remind.Enabled=False";
_time_remind.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence("0:0"));
 };
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Dim sec2 As String=sec1";
_sec2 = BA.NumberToString(_sec1);
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Dim min2 As String=min1";
_min2 = BA.NumberToString(_min1);
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="Select sec2";
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="sec2=\"00\"";
_sec2 = "00";
 break; }
case 1: {
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="sec2=\"01\"";
_sec2 = "01";
 break; }
case 2: {
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="sec2=\"02\"";
_sec2 = "02";
 break; }
case 3: {
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="sec2=\"03\"";
_sec2 = "03";
 break; }
case 4: {
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="sec2=\"04\"";
_sec2 = "04";
 break; }
case 5: {
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="sec2=\"05\"";
_sec2 = "05";
 break; }
case 6: {
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="sec2=\"06\"";
_sec2 = "06";
 break; }
case 7: {
RDebugUtils.currentLine=3932185;
 //BA.debugLineNum = 3932185;BA.debugLine="sec2=\"07\"";
_sec2 = "07";
 break; }
case 8: {
RDebugUtils.currentLine=3932187;
 //BA.debugLineNum = 3932187;BA.debugLine="sec2=\"08\"";
_sec2 = "08";
 break; }
case 9: {
RDebugUtils.currentLine=3932189;
 //BA.debugLineNum = 3932189;BA.debugLine="sec2=\"09\"";
_sec2 = "09";
 break; }
}
;
RDebugUtils.currentLine=3932191;
 //BA.debugLineNum = 3932191;BA.debugLine="Select min2";
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
RDebugUtils.currentLine=3932193;
 //BA.debugLineNum = 3932193;BA.debugLine="min2=\"00\"";
_min2 = "00";
 break; }
case 1: {
RDebugUtils.currentLine=3932195;
 //BA.debugLineNum = 3932195;BA.debugLine="min2=\"01\"";
_min2 = "01";
 break; }
case 2: {
RDebugUtils.currentLine=3932197;
 //BA.debugLineNum = 3932197;BA.debugLine="min2=\"02\"";
_min2 = "02";
 break; }
case 3: {
RDebugUtils.currentLine=3932199;
 //BA.debugLineNum = 3932199;BA.debugLine="min2=\"03\"";
_min2 = "03";
 break; }
case 4: {
RDebugUtils.currentLine=3932201;
 //BA.debugLineNum = 3932201;BA.debugLine="min2=\"04\"";
_min2 = "04";
 break; }
case 5: {
RDebugUtils.currentLine=3932203;
 //BA.debugLineNum = 3932203;BA.debugLine="min2=\"05\"";
_min2 = "05";
 break; }
case 6: {
RDebugUtils.currentLine=3932205;
 //BA.debugLineNum = 3932205;BA.debugLine="min2=\"06\"";
_min2 = "06";
 break; }
case 7: {
RDebugUtils.currentLine=3932207;
 //BA.debugLineNum = 3932207;BA.debugLine="min2=\"07\"";
_min2 = "07";
 break; }
case 8: {
RDebugUtils.currentLine=3932209;
 //BA.debugLineNum = 3932209;BA.debugLine="min2=\"08\"";
_min2 = "08";
 break; }
case 9: {
RDebugUtils.currentLine=3932211;
 //BA.debugLineNum = 3932211;BA.debugLine="min2=\"09\"";
_min2 = "09";
 break; }
}
;
RDebugUtils.currentLine=3932214;
 //BA.debugLineNum = 3932214;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
mostCurrent._lbl_time_remind.setText(BA.ObjectToCharSequence(_min2+":"+_sec2));
RDebugUtils.currentLine=3932216;
 //BA.debugLineNum = 3932216;BA.debugLine="If(sec1<1)Then";
if ((_sec1<1)) { 
RDebugUtils.currentLine=3932217;
 //BA.debugLineNum = 3932217;BA.debugLine="min1=min1-1";
_min1 = (int) (_min1-1);
RDebugUtils.currentLine=3932218;
 //BA.debugLineNum = 3932218;BA.debugLine="sec1=60";
_sec1 = (int) (60);
 };
RDebugUtils.currentLine=3932221;
 //BA.debugLineNum = 3932221;BA.debugLine="sec1=sec1-1";
_sec1 = (int) (_sec1-1);
RDebugUtils.currentLine=3932222;
 //BA.debugLineNum = 3932222;BA.debugLine="End Sub";
return "";
}
}