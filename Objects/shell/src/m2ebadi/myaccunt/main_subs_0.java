package m2ebadi.myaccunt;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"step0\")";
Debug.ShouldStop(32);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step0")),main.mostCurrent.activityBA);
 BA.debugLineNum = 39;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
Debug.ShouldStop(64);
main._time_remind.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("time_remind")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("activity_pause")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 111;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("activity_resume")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 107;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_code_num_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_code_num_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,147);
if (RapidSub.canDelegate("et_code_num_textchanged")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","et_code_num_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 147;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="lbl_run2_step0.Enabled=True";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_run2_step0.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private et_phonNum As EditText";
main.mostCurrent._et_phonnum = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private et_code_num As EditText";
main.mostCurrent._et_code_num = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pan_all_send As Panel";
main.mostCurrent._pan_all_send = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lbl_run2_step0 As Label";
main.mostCurrent._lbl_run2_step0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim ht As HttpJob";
main.mostCurrent._ht = RemoteObject.createNew ("m2ebadi.myaccunt.httpjob");
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_time_remind As Label";
main.mostCurrent._lbl_time_remind = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim min1 As Int=14";
main._min1 = BA.numberCast(int.class, 14);
 //BA.debugLineNum = 33;BA.debugLine="Dim sec1 As Int=59";
main._sec1 = BA.numberCast(int.class, 59);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("http_initial_1")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 153;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 155;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 156;BA.debugLine="ht.Initialize(\"ht1\",Me)";
Debug.ShouldStop(134217728);
main.mostCurrent._ht.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(main.getObject()));
 BA.debugLineNum = 157;BA.debugLine="Dim send As String";
Debug.ShouldStop(268435456);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 158;BA.debugLine="send = \"id=1&num=\"&phon_num&\"&code=0\"";
Debug.ShouldStop(536870912);
_send = RemoteObject.concat(RemoteObject.createImmutable("id=1&num="),main._phon_num,RemoteObject.createImmutable("&code=0"));Debug.locals.put("send", _send);
 BA.debugLineNum = 159;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
Debug.ShouldStop(1073741824);
main.mostCurrent._ht.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/sms_req.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 161;BA.debugLine="Else if (type1=2)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 163;BA.debugLine="ht.Initialize(\"ht2\",Me)";
Debug.ShouldStop(4);
main.mostCurrent._ht.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(main.getObject()));
 BA.debugLineNum = 164;BA.debugLine="Dim send As String";
Debug.ShouldStop(8);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 165;BA.debugLine="send = \"id=2&num=\"&phon_num&\"&code=\"&et_code_num";
Debug.ShouldStop(16);
_send = RemoteObject.concat(RemoteObject.createImmutable("id=2&num="),main._phon_num,RemoteObject.createImmutable("&code="),main.mostCurrent._et_code_num.runMethod(true,"getText"));Debug.locals.put("send", _send);
 BA.debugLineNum = 166;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/sms_req.p";
Debug.ShouldStop(32);
main.mostCurrent._ht.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/sms_req.php")),(Object)(_send));
 }}
;
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Jobdone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,175);
if (RapidSub.canDelegate("jobdone")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 175;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 177;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0786434",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 178;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 };
 BA.debugLineNum = 183;BA.debugLine="If job.JobName=\"ht2\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 184;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("okuser"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 185;BA.debugLine="StartActivity(activity_step2)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._activity_step2.getObject())));
 }else 
{ BA.debugLineNum = 186;BA.debugLine="Else if (job.GetString.Contains(\"nouser\")=True)";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 187;BA.debugLine="StartActivity(activity_step1)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._activity_step1.getObject())));
 }else {
 BA.debugLineNum = 189;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("کد تائید اشتباه است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }}
;
 };
 }else {
 };
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_run1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_run1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("lbl_back_run1_click")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","lbl_back_run1_click");}
 BA.debugLineNum = 139;BA.debugLine="Private Sub lbl_back_run1_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 144;BA.debugLine="pan_all_send.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._pan_all_send.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run1_step0_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run1_step0_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("lbl_run1_step0_click")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","lbl_run1_step0_click");}
 BA.debugLineNum = 116;BA.debugLine="Private Sub lbl_run1_step0_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 118;BA.debugLine="StartActivity(activity_step1)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._activity_step1.getObject())));
 BA.debugLineNum = 119;BA.debugLine="phon_num=et_phonNum.Text";
Debug.ShouldStop(4194304);
main._phon_num = main.mostCurrent._et_phonnum.runMethod(true,"getText");
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run2_step0_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run2_step0_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
if (RapidSub.canDelegate("lbl_run2_step0_click")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","lbl_run2_step0_click");}
 BA.debugLineNum = 126;BA.debugLine="Private Sub lbl_run2_step0_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 129;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(1);
_http_initial_1(BA.numberCast(int.class, 2));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_send_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_send_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,135);
if (RapidSub.canDelegate("pan_all_send_click")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","pan_all_send_click");}
 BA.debugLineNum = 135;BA.debugLine="Private Sub pan_all_send_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
activity_step1_subs_0._process_globals();
activity_step2_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.main");
starter.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.starter");
activity_step1.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.activity_step1");
activity_step2.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.activity_step2");
httputils2service.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.httputils2service");
httpjob.myClass = BA.getDeviceClass ("m2ebadi.myaccunt.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim time_remind As Timer";
main._time_remind = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 19;BA.debugLine="Dim phon_num As String";
main._phon_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _time_remind_tick() throws Exception{
try {
		Debug.PushSubsStack("time_remind_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("time_remind_tick")) { return m2ebadi.myaccunt.main.remoteMe.runUserSub(false, "main","time_remind_tick");}
RemoteObject _sec2 = RemoteObject.createImmutable("");
RemoteObject _min2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 43;BA.debugLine="Sub time_remind_Tick";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="If(min1<1 And sec1<1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",main._min1,BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("<",main._sec1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 46;BA.debugLine="time_remind.Enabled=False";
Debug.ShouldStop(8192);
main._time_remind.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 47;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_time_remind.runMethod(true,"setText",BA.ObjectToCharSequence("0:0"));
 };
 BA.debugLineNum = 50;BA.debugLine="Dim sec2 As String=sec1";
Debug.ShouldStop(131072);
_sec2 = BA.NumberToString(main._sec1);Debug.locals.put("sec2", _sec2);Debug.locals.put("sec2", _sec2);
 BA.debugLineNum = 51;BA.debugLine="Dim min2 As String=min1";
Debug.ShouldStop(262144);
_min2 = BA.NumberToString(main._min1);Debug.locals.put("min2", _min2);Debug.locals.put("min2", _min2);
 BA.debugLineNum = 52;BA.debugLine="Select sec2";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 BA.debugLineNum = 54;BA.debugLine="sec2=\"00\"";
Debug.ShouldStop(2097152);
_sec2 = BA.ObjectToString("00");Debug.locals.put("sec2", _sec2);
 break; }
case 1: {
 BA.debugLineNum = 56;BA.debugLine="sec2=\"01\"";
Debug.ShouldStop(8388608);
_sec2 = BA.ObjectToString("01");Debug.locals.put("sec2", _sec2);
 break; }
case 2: {
 BA.debugLineNum = 58;BA.debugLine="sec2=\"02\"";
Debug.ShouldStop(33554432);
_sec2 = BA.ObjectToString("02");Debug.locals.put("sec2", _sec2);
 break; }
case 3: {
 BA.debugLineNum = 60;BA.debugLine="sec2=\"03\"";
Debug.ShouldStop(134217728);
_sec2 = BA.ObjectToString("03");Debug.locals.put("sec2", _sec2);
 break; }
case 4: {
 BA.debugLineNum = 62;BA.debugLine="sec2=\"04\"";
Debug.ShouldStop(536870912);
_sec2 = BA.ObjectToString("04");Debug.locals.put("sec2", _sec2);
 break; }
case 5: {
 BA.debugLineNum = 64;BA.debugLine="sec2=\"05\"";
Debug.ShouldStop(-2147483648);
_sec2 = BA.ObjectToString("05");Debug.locals.put("sec2", _sec2);
 break; }
case 6: {
 BA.debugLineNum = 66;BA.debugLine="sec2=\"06\"";
Debug.ShouldStop(2);
_sec2 = BA.ObjectToString("06");Debug.locals.put("sec2", _sec2);
 break; }
case 7: {
 BA.debugLineNum = 68;BA.debugLine="sec2=\"07\"";
Debug.ShouldStop(8);
_sec2 = BA.ObjectToString("07");Debug.locals.put("sec2", _sec2);
 break; }
case 8: {
 BA.debugLineNum = 70;BA.debugLine="sec2=\"08\"";
Debug.ShouldStop(32);
_sec2 = BA.ObjectToString("08");Debug.locals.put("sec2", _sec2);
 break; }
case 9: {
 BA.debugLineNum = 72;BA.debugLine="sec2=\"09\"";
Debug.ShouldStop(128);
_sec2 = BA.ObjectToString("09");Debug.locals.put("sec2", _sec2);
 break; }
}
;
 BA.debugLineNum = 74;BA.debugLine="Select min2";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 BA.debugLineNum = 76;BA.debugLine="min2=\"00\"";
Debug.ShouldStop(2048);
_min2 = BA.ObjectToString("00");Debug.locals.put("min2", _min2);
 break; }
case 1: {
 BA.debugLineNum = 78;BA.debugLine="min2=\"01\"";
Debug.ShouldStop(8192);
_min2 = BA.ObjectToString("01");Debug.locals.put("min2", _min2);
 break; }
case 2: {
 BA.debugLineNum = 80;BA.debugLine="min2=\"02\"";
Debug.ShouldStop(32768);
_min2 = BA.ObjectToString("02");Debug.locals.put("min2", _min2);
 break; }
case 3: {
 BA.debugLineNum = 82;BA.debugLine="min2=\"03\"";
Debug.ShouldStop(131072);
_min2 = BA.ObjectToString("03");Debug.locals.put("min2", _min2);
 break; }
case 4: {
 BA.debugLineNum = 84;BA.debugLine="min2=\"04\"";
Debug.ShouldStop(524288);
_min2 = BA.ObjectToString("04");Debug.locals.put("min2", _min2);
 break; }
case 5: {
 BA.debugLineNum = 86;BA.debugLine="min2=\"05\"";
Debug.ShouldStop(2097152);
_min2 = BA.ObjectToString("05");Debug.locals.put("min2", _min2);
 break; }
case 6: {
 BA.debugLineNum = 88;BA.debugLine="min2=\"06\"";
Debug.ShouldStop(8388608);
_min2 = BA.ObjectToString("06");Debug.locals.put("min2", _min2);
 break; }
case 7: {
 BA.debugLineNum = 90;BA.debugLine="min2=\"07\"";
Debug.ShouldStop(33554432);
_min2 = BA.ObjectToString("07");Debug.locals.put("min2", _min2);
 break; }
case 8: {
 BA.debugLineNum = 92;BA.debugLine="min2=\"08\"";
Debug.ShouldStop(134217728);
_min2 = BA.ObjectToString("08");Debug.locals.put("min2", _min2);
 break; }
case 9: {
 BA.debugLineNum = 94;BA.debugLine="min2=\"09\"";
Debug.ShouldStop(536870912);
_min2 = BA.ObjectToString("09");Debug.locals.put("min2", _min2);
 break; }
}
;
 BA.debugLineNum = 97;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
Debug.ShouldStop(1);
main.mostCurrent._lbl_time_remind.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_min2,RemoteObject.createImmutable(":"),_sec2)));
 BA.debugLineNum = 99;BA.debugLine="If(sec1<1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",main._sec1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 100;BA.debugLine="min1=min1-1";
Debug.ShouldStop(8);
main._min1 = RemoteObject.solve(new RemoteObject[] {main._min1,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 101;BA.debugLine="sec1=60";
Debug.ShouldStop(16);
main._sec1 = BA.numberCast(int.class, 60);
 };
 BA.debugLineNum = 104;BA.debugLine="sec1=sec1-1";
Debug.ShouldStop(128);
main._sec1 = RemoteObject.solve(new RemoteObject[] {main._sec1,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}