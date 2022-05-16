package m2ebadi.myaccunt;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class activity_step2_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"step2\")";
Debug.ShouldStop(33554432);
activity_step2.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step2")),activity_step2.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_resume");}
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pan_all_edit As Panel";
activity_step2.mostCurrent._pan_all_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_email As EditText";
activity_step2.mostCurrent._et_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_nameFamili As EditText";
activity_step2.mostCurrent._et_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lbl_noske As Label";
activity_step2.mostCurrent._lbl_noske = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lbl_nameFamili As Label";
activity_step2.mostCurrent._lbl_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_email As Label";
activity_step2.mostCurrent._lbl_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,47);
if (RapidSub.canDelegate("lbl_back_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_back_click");}
 BA.debugLineNum = 47;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="pan_all_edit.Visible=False";
Debug.ShouldStop(32768);
activity_step2.mostCurrent._pan_all_edit.runMethod(true,"setVisible",activity_step2.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_logoff_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_logOff_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,51);
if (RapidSub.canDelegate("lbl_logoff_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_logoff_click");}
 BA.debugLineNum = 51;BA.debugLine="Private Sub lbl_logOff_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(524288);
activity_step2.mostCurrent.__c.runVoidMethod ("StartActivity",activity_step2.processBA,(Object)((activity_step2.mostCurrent._main.getObject())));
 BA.debugLineNum = 53;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
activity_step2.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_edit_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_edit_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,43);
if (RapidSub.canDelegate("lbl_save_edit_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_save_edit_click");}
 BA.debugLineNum = 43;BA.debugLine="Private Sub lbl_save_edit_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_edit_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_edit_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,39);
if (RapidSub.canDelegate("pan_all_edit_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","pan_all_edit_click");}
 BA.debugLineNum = 39;BA.debugLine="Private Sub pan_all_edit_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}