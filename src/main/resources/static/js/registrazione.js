document.getElementById('registrationForm').addEventListener('submit', function(event) {
            event.preventDefault(); 
			
            const nome = document.getElementById('nome').value.trim();
            const cognome = document.getElementById('cognome').value.trim();
            const email = document.getElementById('email').value.trim();
            const password = document.getElementById('password').value;
            const confermaPassword = document.getElementById('conferma_password').value;
            const privacy = document.getElementById('privacy').checked;

            
            if (!nome || !cognome || !email || !password || !confermaPassword || !privacy) {
                alert("Compila tutti i campi obbligatori.");
                return;
            }

            if (password.length < 8) {
                alert("La password deve contenere almeno 8 caratteri.");
                return;
            }

            if (password !== confermaPassword) {
                alert("Le password non coincidono.");
                return;
            }

            
            document.getElementById('successModal').style.display = 'flex';
        });