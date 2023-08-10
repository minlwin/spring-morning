document.addEventListener('DOMContentLoaded', () => {
	
	const changePassBtn = document.getElementById('changePassBtn')
	const changePassDialog = document.getElementById('changePassDialog')
	
	if(changePassBtn && changePassDialog) {
		changePassBtn.addEventListener('click', () => {
			let dialog = new bootstrap.Modal(changePassDialog)
			dialog.show()
		})
	}
})