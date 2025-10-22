function openModal(event, mansione, azienda, statoTesto, statoClassi) {
    event.preventDefault(); 

    document.getElementById('modal-mansione').textContent = mansione;
    document.getElementById('modal-azienda').textContent = azienda;

    const statoSpan = document.getElementById('modal-stato');
    statoSpan.textContent = statoTesto.trim();


    statoSpan.className = '';

    if (statoClassi.includes('accepted')) {
        statoSpan.classList.add('accepted');
    } else if (statoClassi.includes('rejected')) {
        statoSpan.classList.add('rejected');
    } else {
        statoSpan.classList.add('pending');
    }


    document.getElementById('detailsModal').style.display = 'flex';
}

function closeModal() {
    document.getElementById('detailsModal').style.display = 'none';
}


window.onclick = function (event) {
    const modal = document.getElementById('detailsModal');
    if (event.target === modal) {
        closeModal();
    }
}


function showSection(sectionId, event) {
    document.querySelectorAll('.profile-section').forEach(section => {
        section.classList.remove('active');
    });

    document.querySelectorAll('.nav-button').forEach(button => {
        button.classList.remove('active');
    });

    document.getElementById(sectionId).classList.add('active');

    const targetButton = event ? event.currentTarget : document.querySelector(`.nav-button[onclick*="${sectionId}"]`);
    if (targetButton) {
        targetButton.classList.add('active');
    }
}

function toggleVisibility(inputId, buttonElement) {
    const passwordInput = document.getElementById(inputId);
    const icon = buttonElement.querySelector('i');

    if (passwordInput.getAttribute('type') === 'password') {
        passwordInput.setAttribute('type', 'text');
        icon.classList.remove('fa-eye');
        icon.classList.add('fa-eye-slash');
    } else {
        passwordInput.setAttribute('type', 'password');
        icon.classList.remove('fa-eye-slash');
        icon.classList.add('fa-eye');
    }
}

document.addEventListener('DOMContentLoaded', () => {

    if (!document.querySelector('.profile-nav .nav-button.active')) {
        document.getElementById('candidature').classList.add('active');
        document.querySelector('.nav-button[onclick*="candidature"]').classList.add('active');
    }

    const fileInputMap = {
        'curriculumFile': 'curriculumFileName'
    };

    for (const inputId in fileInputMap) {
        const fileInput = document.getElementById(inputId);
        const fileNameDisplay = document.getElementById(fileInputMap[inputId]);

        if (fileInput && fileNameDisplay) {
            fileInput.addEventListener('change', function () {
                if (this.files.length > 0) {
                    fileNameDisplay.textContent = this.files[0].name;
                } else {
                    fileNameDisplay.textContent = 'Nessun file selezionato';
                }
            });
        }
    }
});