/* jshint esversion: 6 */
const observer = new IntersectionObserver((enteries) => { passive: true
    enteries.forEach((entry)=>{
        if(entry.isIntersecting){
            entry.target.classList.add('show');
        } else {
            entry.target.classList.remove('show');
        }
    });
});

const hiddenElement = document.querySelectorAll('.hidden');
hiddenElement.forEach((el) => observer.observe(el));


let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}


const movableWindow = document.getElementById("movableWindow");

let offsetX, offsetY, isDragging = false;

movableWindow.addEventListener("mousedown", (e) => {
  // Calculate the initial position of the mouse relative to the top-left corner of the window
  offsetX = e.clientX - movableWindow.offsetLeft;
  offsetY = e.clientY - movableWindow.offsetTop;

  // Set isDragging to true to indicate that dragging has started
  isDragging = true;

  // Change the cursor to grabbing while dragging
  movableWindow.style.cursor = "grabbing";
});

document.addEventListener("mousemove", (e) => {
  if (isDragging) {
    // Calculate the new position of the window based on the mouse movement
    const x = e.clientX - offsetX;
    const y = e.clientY - offsetY;

    // Apply the new position to the window
    movableWindow.style.left = x + "px";
    movableWindow.style.top = y + "px";
  }
});

document.addEventListener("mouseup", () => {
  // Reset the dragging state and cursor style when dragging is finished
  isDragging = false;
  movableWindow.style.cursor = "grab";
});



