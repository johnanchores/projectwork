        let percentage = 0;
        const percentageElement = document.getElementById('percentage');
        const interval = setInterval(() => {
            percentage += 1;
            percentageElement.textContent = `${percentage}%`;
            
            if (percentage >= 100) {
                clearInterval(interval);
                
                setTimeout(() => {
                    window.location.href = "dashboard"; 
                }, 500);
            }
        }, 30); 

        function showLoading() {
            console.log("Loading...");
   
    window.location.href = "../templates/loading.html"; 
    
  }
