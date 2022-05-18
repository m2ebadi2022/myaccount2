
package m2ebadi.myaccunt;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "m2ebadi.myaccunt.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _time_remind = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _phon_num = RemoteObject.createImmutable("");
public static RemoteObject _et_phonnum = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_code_num = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _pan_all_send = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_run2_step0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _ht = RemoteObject.declareNull("m2ebadi.myaccunt.httpjob");
public static RemoteObject _lbl_time_remind = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _min1 = RemoteObject.createImmutable(0);
public static RemoteObject _sec1 = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_run1_step0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static m2ebadi.myaccunt.starter _starter = null;
public static m2ebadi.myaccunt.activity_step1 _activity_step1 = null;
public static m2ebadi.myaccunt.activity_step2 _activity_step2 = null;
public static m2ebadi.myaccunt.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"activity_step1",Debug.moduleToString(m2ebadi.myaccunt.activity_step1.class),"activity_step2",Debug.moduleToString(m2ebadi.myaccunt.activity_step2.class),"et_code_num",main.mostCurrent._et_code_num,"et_phonNum",main.mostCurrent._et_phonnum,"ht",main.mostCurrent._ht,"HttpUtils2Service",Debug.moduleToString(m2ebadi.myaccunt.httputils2service.class),"lbl_run1_step0",main.mostCurrent._lbl_run1_step0,"lbl_run2_step0",main.mostCurrent._lbl_run2_step0,"lbl_time_remind",main.mostCurrent._lbl_time_remind,"min1",main._min1,"pan_all_send",main.mostCurrent._pan_all_send,"phon_num",main._phon_num,"sec1",main._sec1,"Starter",Debug.moduleToString(m2ebadi.myaccunt.starter.class),"time_remind",main._time_remind};
}
}