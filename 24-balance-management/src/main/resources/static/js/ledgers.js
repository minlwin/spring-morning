document.addEventListener('DOMContentLoaded', () => {
	
	const initiater = document.getElementById('addNewBtn')
	
	if(initiater) {
		initiater.addEventListener('click', () => {
			const modalDialog = new bootstrap.Modal("#ledgerEdit")
			modalDialog.show()
		})
	}
})