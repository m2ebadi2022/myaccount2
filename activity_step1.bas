﻿B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle:   False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private et_email As EditText
	Private et_nameFamili As EditText
	Private lbl_run_step1 As Label
	Dim ht2 As HttpJob
	Dim pp As Phone
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step1")



End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_run_step1_Click
	'' chek code in sms
	
	
	http_initial_1(3)
	
	
	
End Sub



Sub http_initial_1(type1 As Int)

	If(type1=3)Then
		ht2.Initialize("ht2",Me)
		Dim send As String
		send = "var=1&phone="&Main.phon_num&"&name="&et_nameFamili.Text&"&email="&et_email.Text&"&type_app=1&div_id="&pp.GetSettings("android_id")&"&div_model="&pp.Model
		ht2.PostString("https://taravatgroup.ir/save_acc.php",send)
		
	End If
	
	
	
End Sub
 


Sub Jobdone (job As HttpJob)
	Log(job.GetString)
	If job.Success = True Then
		
		If job.JobName="ht2" Then
			If(job.GetString.Contains("true"))Then
				StartActivity(activity_step2)
				Activity.Finish
				ToastMessageShow("تبریک",False)
			Else
				ToastMessageShow(job.GetString,False)	
		End If		
		End If
			
		
			
		
	Else
		'ToastMessageShow("خطا در برقراری اتصال" , False)
	End If
End Sub

