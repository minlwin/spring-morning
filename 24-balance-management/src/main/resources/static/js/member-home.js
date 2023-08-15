document.addEventListener('DOMContentLoaded', () => {
	
	const memberProfileEditBtn = document.getElementById('memberProfileEditBtn')
	const memberProfileEditModalDialog = document.getElementById('memberProfileEditModalDialog')
	
	if(memberProfileEditBtn && memberProfileEditModalDialog) {
		memberProfileEditBtn.addEventListener('click', () => {
			let dialog = new bootstrap.Modal(memberProfileEditModalDialog)
			dialog.show()
		})
	}

	const companyProfileEditBtn = document.getElementById('companyProfileEditBtn')
	const companyProfileEditModalDialog = document.getElementById('companyProfileEditModalDialog')
	
	if(companyProfileEditBtn && companyProfileEditModalDialog) {
		companyProfileEditBtn.addEventListener('click', () => {
			let dialog = new bootstrap.Modal(companyProfileEditModalDialog)
			dialog.show()
		})
	}
})