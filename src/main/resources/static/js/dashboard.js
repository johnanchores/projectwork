
const token = document.querySelector("meta[name='_csrf']").getAttribute("content");
const header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

let currentTirocinioId = null;

function handleApply() {
  if (!currentTirocinioId) {
    alert("Errore: Per favore, seleziona un tirocinio dalla lista prima di candidarti.");
    return;
  }

  
  const formData = new URLSearchParams();
  formData.append('id_tirocinio', currentTirocinioId);

  fetch("/candidature", { 
    method: "POST",
    headers: {
     
      "Content-Type": "application/x-www-form-urlencoded",
	  [header]: token
    },
    body: formData,  })
    .then((response) => {
      if (response.ok) {
        alert("Candidatura inviata con successo! ✅");
        window.location.reload(); 
      } else {
        throw new Error("Errore durante la candidatura: " + response.statusText);
      }
    })
    .catch((error) => {
      console.error("Errore di candidatura:", error);
      alert("Candidatura fallita. Riprova più tardi.");
    });
}

function loadJobDetails(clickedCard) {

  document.querySelectorAll('.job-card').forEach(card => card.classList.remove('active'));
  
  clickedCard.classList.add('active');

  const jobId = clickedCard.dataset.jobId;
  const mansione = clickedCard.querySelector("h3").textContent;
  const azienda = clickedCard.querySelector(".company-name").textContent;
  const descrizione = clickedCard.querySelector(".job-description").textContent;
  const logoInitial = clickedCard.querySelector(".company-logo").textContent;
  const competenzeHtml = clickedCard.querySelector(".tags-row").innerHTML;
  
 
  currentTirocinioId = jobId;

  document.getElementById("aside-mansione").textContent = mansione;
  document.getElementById("aside-azienda").textContent = azienda;
  document.getElementById("aside-descrizione").querySelector("p").textContent = descrizione;
  document.getElementById("aside-logo").textContent = logoInitial;
  document.getElementById("aside-competenze").innerHTML = competenzeHtml;

  document.getElementById("jobDetailsOverlay").classList.add("show");
}


function closeJobDetailsOverlay() {
  document.getElementById("jobDetailsOverlay").classList.remove("show");
  document.querySelectorAll('.job-card').forEach(card => card.classList.remove('active'));
}

document.addEventListener("DOMContentLoaded", function () {
 
  document.getElementById("aside-apply-btn").addEventListener("click", handleApply);

 
  document.getElementById("jobDetailsOverlay").addEventListener("click", function (event) {
    if (event.target === this) {
      closeJobDetailsOverlay();
    }
  });
});