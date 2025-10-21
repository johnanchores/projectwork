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
  fetch("/candidatura", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      // **ATTENZIONE:** Includere qui X-CSRF-TOKEN se usi Spring Security.
    },
    body: JSON.stringify({
      tirocinioId: jobId,
    }),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      }
      throw new Error("Errore durante la candidatura: " + response.statusText);
    })
    .then((data) => {
      alert("Candidatura inviata con successo! ✅");

      // Aggiorna lo stato del bottone
      const applyButton = document.getElementById("aside-apply-btn");
      applyButton.textContent = "Candidato!";
      applyButton.disabled = true;
    })
    .catch((error) => {
      console.error("Errore di candidatura:", error);
      alert("Candidatura fallita. Riprova più tardi.");
    });
}

/**
 * Funzione per nascondere l'overlay modale.
 */
function closeJobDetailsOverlay() {
  const overlay = document.getElementById("jobDetailsOverlay");
  overlay.classList.remove("show");

  // Rimuovi la classe 'active' da tutte le card
  const allCards = document.querySelectorAll(".job-card");
  allCards.forEach((card) => card.classList.remove("active"));
}

/**
 * Aggiunge un gestore di eventi per chiudere l'overlay cliccando sullo sfondo.
 * Esegue solo una volta al caricamento.
 */
document.addEventListener("DOMContentLoaded", function () {
  document
    .getElementById("jobDetailsOverlay")
    .addEventListener("click", function (event) {
      // Chiude se l'elemento cliccato è ESATTAMENTE il contenitore overlay (lo sfondo scuro)
      if (event.target === this) {
        closeJobDetailsOverlay();
      }
    });
});

/**
 * Aggiorna il pannello dei dettagli quando una card viene cliccata
 * e mostra l'overlay.
 * @param {HTMLElement} clickedCard La card del lavoro cliccata.
 */
function loadJobDetails(clickedCard) {
  // 1. GESTIONE CLASSE 'ACTIVE'
  const allCards = document.querySelectorAll(".job-card");
  allCards.forEach((card) => card.classList.remove("active"));
  clickedCard.classList.add("active");

  // 2. RECUPERO DATI DALLA CARD
  const jobId = clickedCard.dataset.jobId;
  const mansione = clickedCard.querySelector("h3").textContent;
  const azienda = clickedCard.querySelector(".company-name").textContent;
  const descrizioneBreve =
    clickedCard.querySelector(".job-description").textContent;
  // documentName Rimosso

  // 3. AGGIORNAMENTO DEL PANNELLO ASIDE (Header e Descrizione)
  document.getElementById("aside-mansione").textContent = mansione;
  document.getElementById("aside-azienda").textContent = azienda;

  // Simula l'iniziale del logo
  const initial = azienda.charAt(0).toUpperCase();
  document.getElementById("aside-logo").textContent = initial;

  // Aggiornamento Descrizione
  document.getElementById(
    "aside-descrizione"
  ).innerHTML = `<p>${descrizioneBreve}</p>`;

  // 4. SEZIONE DOCUMENTO COMPLETAMENTE RIMOSSA

  // 5. COLLEGAMENTO DELL'AZIONE POST AL BOTTONE CANDIDATI
  const applyButton = document.getElementById("aside-apply-btn");

  // Resetta lo stato del bottone e il gestore di eventi
  applyButton.textContent = "Candidati";
  applyButton.disabled = false;
  applyButton.onclick = null;

  if (applyButton) {
    // Assegna la nuova funzione handleApply con l'ID corrente
    applyButton.onclick = function () {
      handleApply(jobId);
    };
  }

  // 6. MOSTRA L'OVERLAY
  const overlay = document.getElementById("jobDetailsOverlay");
  overlay.classList.add("show");

  // Scrolla in cima al modale
  document.querySelector(".job-details-panel").scrollTop = 0;
}
