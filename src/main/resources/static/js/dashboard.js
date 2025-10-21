function loadJobDetails(clickedCard) {
    // 1. GESTIONE CLASSE 'ACTIVE'
    // Rimuove la classe 'active' da tutte le card
    const allCards = document.querySelectorAll('.job-card');
    allCards.forEach(card => card.classList.remove('active'));

    // Aggiunge la classe 'active' alla card cliccata
    clickedCard.classList.add('active');

    // 2. RECUPERO DATI DALLA CARD
    // Dati visualizzati sulla card
    const mansione = clickedCard.querySelector('h3').textContent;
    const azienda = clickedCard.querySelector('.company-name').textContent;
    const descrizioneBreve = clickedCard.querySelector('.job-description').textContent;
    
    // Dati passati tramite data-attributes per le azioni
    const documentName = clickedCard.dataset.documentName;
    const applyUrl = clickedCard.dataset.applyUrl || '#'; // '#' se non c'è URL

    // 3. AGGIORNAMENTO DEL PANNELLO ASIDE (Header e Descrizione)
    document.getElementById('aside-mansione').textContent = mansione;
    document.getElementById('aside-azienda').textContent = azienda;
    
    // Simula l'iniziale del logo
    document.getElementById('aside-logo').textContent = azienda.charAt(0).toUpperCase();

    // Aggiornamento Descrizione (nota: in una vera app useresti i dati completi dal server)
    document.getElementById('aside-descrizione').innerHTML = `<p>${descrizioneBreve}</p>`; 

    // 4. AGGIORNAMENTO DOCUMENTO (Sezione Dinamica)
    const documentLinkContainer = document.getElementById('aside-document-link');
    if (documentName && documentName !== 'null') { // Verifica se il nome del documento è presente
        documentLinkContainer.innerHTML = `
            <i class="material-icons">description</i>
            <span>${documentName}</span>
        `;
    } else {
        documentLinkContainer.innerHTML = ''; // Nasconde se non c'è documento
    }

    // 5. AGGIORNAMENTO AZIONI (Bottone Candidati)
    const applyButton = document.getElementById('aside-apply-btn');
    if (applyButton) {
        // Assegna l'URL come attributo dati, puoi usarlo per reindirizzare o aprire un modale
        applyButton.setAttribute('data-url', applyUrl); 
        
        // Esempio: reindirizza al click
        applyButton.onclick = function() {
            // Nota: in un'applicazione seria, qui si aggiungerebbe un target="_blank"
            // o si gestirebbe l'evento con un modale.
            window.open(applyUrl, '_blank');
        };
    }
    
    // Opzionale: scrolla l'aside nella vista sui dispositivi mobili
    document.querySelector('.job-details-panel').scrollTop = 0;
}

/**
 * Gestisce l'invio della richiesta di candidatura tramite POST.
 * @param {string} jobId L'ID univoco del tirocinio a cui candidarsi.
 */
function handleApply(jobId) {
    if (!jobId) {
        console.error("ID del tirocinio non trovato per la candidatura.");
        alert("Errore: Impossibile candidarsi senza ID del tirocinio.");
        return;
    }
    
    // Richiesta POST al server
    fetch('/candidatura', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // **ATTENZIONE:** Se usi Spring Security, potresti dover includere
            // qui l'header X-CSRF-TOKEN.
        },
        body: JSON.stringify({
            tirocinioId: jobId
        })
    })
    .then(response => {
        if (response.ok) {
            return response.json(); 
        }
        throw new Error('Errore durante la candidatura: ' + response.statusText);
    })
    .then(data => {
        alert("Candidatura inviata con successo! ✅");
        
        // Aggiorna lo stato del bottone
        const applyButton = document.getElementById('aside-apply-btn');
        applyButton.textContent = "Candidato!";
        applyButton.disabled = true;
    })
    .catch(error => {
        console.error('Errore di candidatura:', error);
        alert("Candidatura fallita. Riprova più tardi.");
    });
}


/**
 * Aggiorna il pannello dei dettagli quando una card viene cliccata.
 * @param {HTMLElement} clickedCard La card del lavoro cliccata.
 */
function loadJobDetails(clickedCard) {
    // 1. GESTIONE CLASSE 'ACTIVE'
    const allCards = document.querySelectorAll('.job-card');
    allCards.forEach(card => card.classList.remove('active'));
    clickedCard.classList.add('active');

    // 2. RECUPERO DATI DALLA CARD
    const jobId = clickedCard.dataset.jobId; 
    const mansione = clickedCard.querySelector('h3').textContent;
    const azienda = clickedCard.querySelector('.company-name').textContent;
    const descrizioneBreve = clickedCard.querySelector('.job-description').textContent;
    const documentName = clickedCard.dataset.documentName; 
    
    // 3. AGGIORNAMENTO DEL PANNELLO ASIDE (Header e Descrizione)
    document.getElementById('aside-mansione').textContent = mansione;
    document.getElementById('aside-azienda').textContent = azienda;
    document.getElementById('aside-logo').textContent = azienda.charAt(0).toUpperCase();
    document.getElementById('aside-descrizione').innerHTML = `<p>${descrizioneBreve}</p>`; 

    // 4. AGGIORNAMENTO DOCUMENTO
    const documentLinkContainer = document.getElementById('aside-document-link');
    if (documentName && documentName !== 'null' && documentName.trim() !== '') {
        documentLinkContainer.innerHTML = `
            <i class="material-icons">description</i>
            <span>${documentName}</span>
        `;
    } else {
        documentLinkContainer.innerHTML = ''; 
    }

    // 5. COLLEGAMENTO DELL'AZIONE POST AL BOTTONE CANDIDATI
    const applyButton = document.getElementById('aside-apply-btn');
    
    // Resetta lo stato del bottone e il gestore di eventi
    applyButton.textContent = "Candidati";
    applyButton.disabled = false; 
    applyButton.onclick = null; 
        
    if (applyButton) {
        // Assegna la nuova funzione handleApply con l'ID corrente
        applyButton.onclick = function() {
            handleApply(jobId);
        };
    }
    
    // Opzionale: scrolla l'aside nella vista sui dispositivi mobili
    document.querySelector('.job-details-panel').scrollTop = 0;
}