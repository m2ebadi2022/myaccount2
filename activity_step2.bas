B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle:  False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pan_all_edit As Panel
	Private et_email As EditText
	Private et_nameFamili As EditText
	Private lbl_noske As Label
	Private lbl_nameFamili As Label
	Private lbl_email As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step2")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub pan_all_edit_Click
	
End Sub

Private Sub lbl_save_edit_Click
	
End Sub

Private Sub lbl_back_Click
	pan_all_edit.Visible=False
End Sub

Private Sub lbl_logOff_Click
	StartActivity(Main)
	Activity.Finish
End Sub