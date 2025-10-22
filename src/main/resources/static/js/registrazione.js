document
  .getElementById("registrationForm")
  .addEventListener("submit", function (event) {
    const nome = document.getElementById("nome").value.trim();
    const cognome = document.getElementById("cognome").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;
    const confermaPassword = document.getElementById("confermaPassword").value;

    if (!nome || !cognome || !email || !password || !confermaPassword) {
      event.preventDefault();
      alert("Compila tutti i campi obbligatori.");
      return;
    }

    const nomeCognomeRegex = /^[A-Za-zÀ-ÿ\s]+$/;
    if (!nomeCognomeRegex.test(nome) || !nomeCognomeRegex.test(cognome)) {
      event.preventDefault();
      alert("Nome e cognome possono contenere solo lettere e spazi.");
      return;
    }

    if (password.length < 8) {
      event.preventDefault();
      alert("La password deve contenere almeno 8 caratteri.");
      return;
    }

    if (password !== confermaPassword) {
      event.preventDefault();
      alert("Le password non coincidono.");
      return;
    }
  });
