
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

public class activity_step2 implements IRemote{
	public static activity_step2 mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public activity_step2() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("activity_step2"), "m2ebadi.myaccunt.activity_step2");
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
		pcBA = new PCBA(this, activity_step2.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pan_all_edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_email = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_namefamili = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_noske = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_namefamili = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_email = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _ht1 = RemoteObject.declareNull("m2ebadi.myaccunt.httpjob");
public static RemoteObject _lbl_phonenum = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static m2ebadi.myaccunt.main _main = null;
public static m2ebadi.myaccunt.starter _starter = null;
public static m2ebadi.myaccunt.activity_step1 _activity_step1 = null;
public static m2ebadi.myaccunt.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",activity_step2.mostCurrent._activity,"activity_step1",Debug.moduleToString(m2ebadi.myaccunt.activity_step1.class),"et_email",activity_step2.mostCurrent._et_email,"et_nameFamili",activity_step2.mostCurrent._et_namefamili,"ht1",activity_step2.mostCurrent._ht1,"HttpUtils2Service",Debug.moduleToString(m2ebadi.myaccunt.httputils2service.class),"lbl_email",activity_step2.mostCurrent._lbl_email,"lbl_nameFamili",activity_step2.mostCurrent._lbl_namefamili,"lbl_noske",activity_step2.mostCurrent._lbl_noske,"lbl_phoneNum",activity_step2.mostCurrent._lbl_phonenum,"Main",Debug.moduleToString(m2ebadi.myaccunt.main.class),"pan_all_edit",activity_step2.mostCurrent._pan_all_edit,"Starter",Debug.moduleToString(m2ebadi.myaccunt.starter.class)};
}
}