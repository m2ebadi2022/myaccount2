package m2ebadi.myaccunt;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class activity_step2_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"step2\")";
Debug.ShouldStop(268435456);
activity_step2.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step2")),activity_step2.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(4);
if ((activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 36;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
Debug.ShouldStop(8);
activity_step2.mostCurrent._main._phon_num /*RemoteObject*/  = activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 BA.debugLineNum = 37;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(16);
_http_initial_1(BA.numberCast(int.class, 1));
 }else {
 BA.debugLineNum = 39;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(64);
activity_step2.mostCurrent.__c.runVoidMethod ("StartActivity",activity_step2.processBA,(Object)((activity_step2.mostCurrent._main.getObject())));
 BA.debugLineNum = 40;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
activity_step2.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,53);
if (RapidSub.canDelegate("activity_pause")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,49);
if (RapidSub.canDelegate("activity_resume")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","activity_resume");}
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 23;BA.debugLine="Dim ht1 As HttpJob";
activity_step2.mostCurrent._ht1 = RemoteObject.createNew ("m2ebadi.myaccunt.httpjob");
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_phoneNum As Label";
activity_step2.mostCurrent._lbl_phonenum = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,79);
if (RapidSub.canDelegate("http_initial_1")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 79;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 82;BA.debugLine="ht1.Initialize(\"ht1\",Me)";
Debug.ShouldStop(131072);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,activity_step2.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(activity_step2.getObject()));
 BA.debugLineNum = 83;BA.debugLine="Dim send As String";
Debug.ShouldStop(262144);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 84;BA.debugLine="send = \"var=3&phone=\"&Main.phon_num&\"";
Debug.ShouldStop(524288);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=3&phone="),activity_step2.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable(""));Debug.locals.put("send", _send);
 BA.debugLineNum = 85;BA.debugLine="ht1.PostString(\"https://taravatgroup.ir/save_acc";
Debug.ShouldStop(1048576);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 };
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Jobdone (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,94);
if (RapidSub.canDelegate("jobdone")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","jobdone", _job);}
RemoteObject _a = null;
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("job", _job);
 BA.debugLineNum = 94;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(1073741824);
activity_step2.mostCurrent.__c.runVoidMethod ("LogImpl","62424833",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 96;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),activity_step2.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 98;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 BA.debugLineNum = 99;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
Debug.ShouldStop(4);
if ((_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 100;BA.debugLine="Log (\"account not exist\")";
Debug.ShouldStop(8);
activity_step2.mostCurrent.__c.runVoidMethod ("LogImpl","62424838",RemoteObject.createImmutable("account not exist"),0);
 BA.debugLineNum = 101;BA.debugLine="lbl_logOff_Click";
Debug.ShouldStop(16);
_lbl_logoff_click();
 }else {
 BA.debugLineNum = 104;BA.debugLine="Dim a() As String";
Debug.ShouldStop(128);
_a = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 105;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
Debug.ShouldStop(256);
_a = activity_step2.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("&")),(Object)(_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ )));Debug.locals.put("a", _a);
 BA.debugLineNum = 107;BA.debugLine="lbl_nameFamili.Text=a(0)";
Debug.ShouldStop(1024);
activity_step2.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 108;BA.debugLine="lbl_email.Text=a(1)";
Debug.ShouldStop(2048);
activity_step2.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 110;BA.debugLine="If(a(2)=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_a.getArrayElement(true,BA.numberCast(int.class, 2)),BA.NumberToString(1)))) { 
 BA.debugLineNum = 111;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(16384);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
 BA.debugLineNum = 113;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(65536);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 };
 BA.debugLineNum = 116;BA.debugLine="lbl_phoneNum.Text=a(3)";
Debug.ShouldStop(524288);
activity_step2.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 3))));
 BA.debugLineNum = 118;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
Debug.ShouldStop(2097152);
activity_step2.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("userAcc")),(Object)(activity_step2.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_a))));
 };
 };
 }else {
 BA.debugLineNum = 128;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True)";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc"))),activity_step2.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 130;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(2);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 131;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(4);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 132;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc";
Debug.ShouldStop(8);
_ls_user = activity_step2.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 134;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
Debug.ShouldStop(32);
activity_step2.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 135;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
Debug.ShouldStop(64);
activity_step2.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 137;BA.debugLine="If(ls_user.Get(2)=\"1\")Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("1"))))) { 
 BA.debugLineNum = 138;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(512);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
 BA.debugLineNum = 140;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(2048);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 };
 BA.debugLineNum = 143;BA.debugLine="lbl_phoneNum.Text=ls_user.Get(3)";
Debug.ShouldStop(16384);
activity_step2.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 };
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,66);
if (RapidSub.canDelegate("lbl_back_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_back_click");}
 BA.debugLineNum = 66;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="pan_all_edit.Visible=False";
Debug.ShouldStop(4);
activity_step2.mostCurrent._pan_all_edit.runMethod(true,"setVisible",activity_step2.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("lbl_logOff_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,70);
if (RapidSub.canDelegate("lbl_logoff_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_logoff_click");}
 BA.debugLineNum = 70;BA.debugLine="Private Sub lbl_logOff_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
Debug.ShouldStop(64);
activity_step2.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));
 BA.debugLineNum = 73;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(256);
activity_step2.mostCurrent.__c.runVoidMethod ("StartActivity",activity_step2.processBA,(Object)((activity_step2.mostCurrent._main.getObject())));
 BA.debugLineNum = 74;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
activity_step2.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("lbl_save_edit_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,62);
if (RapidSub.canDelegate("lbl_save_edit_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_save_edit_click");}
 BA.debugLineNum = 62;BA.debugLine="Private Sub lbl_save_edit_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_all_edit_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,58);
if (RapidSub.canDelegate("pan_all_edit_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","pan_all_edit_click");}
 BA.debugLineNum = 58;BA.debugLine="Private Sub pan_all_edit_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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