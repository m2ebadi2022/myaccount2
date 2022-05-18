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
		Debug.PushSubsStack("http_initial_1 (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,80);
if (RapidSub.canDelegate("http_initial_1")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 80;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 83;BA.debugLine="ht1.Initialize(\"ht1\",Me)";
Debug.ShouldStop(262144);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,activity_step2.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(activity_step2.getObject()));
 BA.debugLineNum = 84;BA.debugLine="Dim send As String";
Debug.ShouldStop(524288);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 85;BA.debugLine="send = \"var=3&phone=\"&Main.phon_num&\"";
Debug.ShouldStop(1048576);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=3&phone="),activity_step2.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable(""));Debug.locals.put("send", _send);
 BA.debugLineNum = 86;BA.debugLine="ht1.PostString(\"https://taravatgroup.ir/save_acc";
Debug.ShouldStop(2097152);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 87;BA.debugLine="Else If(type1=2)Then ' to edit";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 88;BA.debugLine="ht1.Initialize(\"ht2\",Me)";
Debug.ShouldStop(8388608);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_initialize" /*RemoteObject*/ ,activity_step2.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(activity_step2.getObject()));
 BA.debugLineNum = 89;BA.debugLine="Dim send As String";
Debug.ShouldStop(16777216);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 90;BA.debugLine="send = \"var=2&name=\"&et_nameFamili.Text&\"&email=";
Debug.ShouldStop(33554432);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=2&name="),activity_step2.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("&email="),activity_step2.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("&phone="),activity_step2.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable(""));Debug.locals.put("send", _send);
 BA.debugLineNum = 91;BA.debugLine="ht1.PostString(\"https://taravatgroup.ir/save_acc";
Debug.ShouldStop(67108864);
activity_step2.mostCurrent._ht1.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }}
;
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Jobdone (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,100);
if (RapidSub.canDelegate("jobdone")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","jobdone", _job);}
RemoteObject _a = null;
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("job", _job);
 BA.debugLineNum = 100;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(16);
activity_step2.mostCurrent.__c.runVoidMethod ("LogImpl","44784129",_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 102;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),activity_step2.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 104;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 BA.debugLineNum = 105;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
Debug.ShouldStop(256);
if ((_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 106;BA.debugLine="Log (\"account not exist\")";
Debug.ShouldStop(512);
activity_step2.mostCurrent.__c.runVoidMethod ("LogImpl","44784134",RemoteObject.createImmutable("account not exist"),0);
 BA.debugLineNum = 107;BA.debugLine="lbl_logOff_Click";
Debug.ShouldStop(1024);
_lbl_logoff_click();
 }else {
 BA.debugLineNum = 110;BA.debugLine="Dim a() As String";
Debug.ShouldStop(8192);
_a = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 111;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
Debug.ShouldStop(16384);
_a = activity_step2.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("&")),(Object)(_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ )));Debug.locals.put("a", _a);
 BA.debugLineNum = 113;BA.debugLine="lbl_nameFamili.Text=a(0)";
Debug.ShouldStop(65536);
activity_step2.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 114;BA.debugLine="lbl_email.Text=a(1)";
Debug.ShouldStop(131072);
activity_step2.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 116;BA.debugLine="If(a(2)=1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_a.getArrayElement(true,BA.numberCast(int.class, 2)),BA.NumberToString(1)))) { 
 BA.debugLineNum = 117;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(1048576);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
 BA.debugLineNum = 119;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(4194304);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 };
 BA.debugLineNum = 122;BA.debugLine="lbl_phoneNum.Text=a(3)";
Debug.ShouldStop(33554432);
activity_step2.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 3))));
 BA.debugLineNum = 124;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
Debug.ShouldStop(134217728);
activity_step2.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("userAcc")),(Object)(activity_step2.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_a))));
 };
 };
 BA.debugLineNum = 129;BA.debugLine="If job.JobName=\"ht2\" Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 130;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
Debug.ShouldStop(2);
if ((_job.runClassMethod (m2ebadi.myaccunt.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("true")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 131;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(4);
_http_initial_1(BA.numberCast(int.class, 1));
 BA.debugLineNum = 132;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(8);
_lbl_back_click();
 BA.debugLineNum = 133;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(16);
activity_step2.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(activity_step2.mostCurrent.__c.getField(true,"False")));
 };
 };
 }else {
 BA.debugLineNum = 140;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True)";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc"))),activity_step2.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 142;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(8192);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 143;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(16384);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 144;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc";
Debug.ShouldStop(32768);
_ls_user = activity_step2.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 146;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
Debug.ShouldStop(131072);
activity_step2.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 147;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
Debug.ShouldStop(262144);
activity_step2.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 149;BA.debugLine="If(ls_user.Get(2)=\"1\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("1"))))) { 
 BA.debugLineNum = 150;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(2097152);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 }else {
 BA.debugLineNum = 152;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(8388608);
activity_step2.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 };
 BA.debugLineNum = 155;BA.debugLine="lbl_phoneNum.Text=ls_user.Get(3)";
Debug.ShouldStop(67108864);
activity_step2.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 };
 };
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_back_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,67);
if (RapidSub.canDelegate("lbl_back_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_back_click");}
 BA.debugLineNum = 67;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="pan_all_edit.Visible=False";
Debug.ShouldStop(8);
activity_step2.mostCurrent._pan_all_edit.runMethod(true,"setVisible",activity_step2.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,167);
if (RapidSub.canDelegate("lbl_edit_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_edit_click");}
 BA.debugLineNum = 167;BA.debugLine="Private Sub lbl_edit_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
Debug.ShouldStop(128);
activity_step2.mostCurrent._et_namefamili.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(activity_step2.mostCurrent._lbl_namefamili.runMethod(true,"getText")));
 BA.debugLineNum = 169;BA.debugLine="et_email.Text=lbl_email.Text";
Debug.ShouldStop(256);
activity_step2.mostCurrent._et_email.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(activity_step2.mostCurrent._lbl_email.runMethod(true,"getText")));
 BA.debugLineNum = 171;BA.debugLine="pan_all_edit.Visible=True";
Debug.ShouldStop(1024);
activity_step2.mostCurrent._pan_all_edit.runMethod(true,"setVisible",activity_step2.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lbl_logOff_Click (activity_step2) ","activity_step2",3,activity_step2.mostCurrent.activityBA,activity_step2.mostCurrent,71);
if (RapidSub.canDelegate("lbl_logoff_click")) { return m2ebadi.myaccunt.activity_step2.remoteMe.runUserSub(false, "activity_step2","lbl_logoff_click");}
 BA.debugLineNum = 71;BA.debugLine="Private Sub lbl_logOff_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
Debug.ShouldStop(128);
activity_step2.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(activity_step2.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));
 BA.debugLineNum = 74;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(512);
activity_step2.mostCurrent.__c.runVoidMethod ("StartActivity",activity_step2.processBA,(Object)((activity_step2.mostCurrent._main.getObject())));
 BA.debugLineNum = 75;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
activity_step2.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 BA.debugLineNum = 64;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(-2147483648);
_http_initial_1(BA.numberCast(int.class, 2));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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