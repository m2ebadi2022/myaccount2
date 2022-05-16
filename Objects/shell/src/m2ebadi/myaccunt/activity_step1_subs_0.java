package m2ebadi.myaccunt;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class activity_step1_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"step1\")";
Debug.ShouldStop(16777216);
activity_step1.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step1")),activity_step1.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Pause (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_email As EditText";
activity_step1.mostCurrent._et_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_nameFamili As EditText";
activity_step1.mostCurrent._et_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_run_step1 As Label";
activity_step1.mostCurrent._lbl_run_step1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim ht2 As HttpJob";
activity_step1.mostCurrent._ht2 = RemoteObject.createNew ("m2ebadi.myaccunt.httpjob");
 //BA.debugLineNum = 20;BA.debugLine="Dim pp As Phone";
activity_step1.mostCurrent._pp = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,50);
if (RapidSub.canDelegate("http_initial_1")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 50;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="If(type1=3)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 53;BA.debugLine="ht2.Initialize(\"ht2\",Me)";
Debug.ShouldStop(1048576);
activity_step1.mostCurrent._ht2.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,activity_step1.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(activity_step1.getObject()));
 BA.debugLineNum = 54;BA.debugLine="Dim send As String";
Debug.ShouldStop(2097152);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 55;BA.debugLine="send = \"var=1&phone=\"&Main.phon_num&\"&name=\"&et_";
Debug.ShouldStop(4194304);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=1&phone="),activity_step1.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),activity_step1.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("&email="),activity_step1.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("&type_app=1&div_id="),activity_step1.mostCurrent._pp.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&div_model="),activity_step1.mostCurrent._pp.runMethod(true,"getModel"));Debug.locals.put("send", _send);
 BA.debugLineNum = 56;BA.debugLine="ht2.PostString(\"https://taravatgroup.ir/save_acc";
Debug.ShouldStop(8388608);
activity_step1.mostCurrent._ht2.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 };
 BA.debugLineNum = 59;BA.debugLine="Log(send)";
Debug.ShouldStop(67108864);
activity_step1.mostCurrent.__c.runVoidMethod ("LogImpl","01638409",_send,0);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("Jobdone (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,66);
if (RapidSub.canDelegate("jobdone")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 66;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(4);
activity_step1.mostCurrent.__c.runVoidMethod ("LogImpl","01703937",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 68;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),activity_step1.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 70;BA.debugLine="If job.JobName=\"ht2\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 71;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
Debug.ShouldStop(64);
if ((_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("true")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 72;BA.debugLine="StartActivity(activity_step2)";
Debug.ShouldStop(128);
activity_step1.mostCurrent.__c.runVoidMethod ("StartActivity",activity_step1.processBA,(Object)((activity_step1.mostCurrent._activity_step2.getObject())));
 BA.debugLineNum = 73;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
activity_step1.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 75;BA.debugLine="ToastMessageShow(job.GetString,False)";
Debug.ShouldStop(1024);
activity_step1.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ))),(Object)(activity_step1.mostCurrent.__c.getField(true,"False")));
 };
 };
 }else {
 };
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run_step1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run_step1_Click (activity_step1) ","activity_step1",2,activity_step1.mostCurrent.activityBA,activity_step1.mostCurrent,38);
if (RapidSub.canDelegate("lbl_run_step1_click")) { return m2ebadi.myaccunt.activity_step1.remoteMe.runUserSub(false, "activity_step1","lbl_run_step1_click");}
 BA.debugLineNum = 38;BA.debugLine="Private Sub lbl_run_step1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 42;BA.debugLine="http_initial_1(3)";
Debug.ShouldStop(512);
_http_initial_1(BA.numberCast(int.class, 3));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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