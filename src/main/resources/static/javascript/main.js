/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* add hovered class to selected list*/
let list = document.querySelectorAll(".navigation li");
 
 
 function activeLink(){
     list.forEach((item) => {
     item.classList.remove("hovered");  
 });
    this.classList.add("hovered");
 }
 
 list.forEach(item => item.addEventListener("mouseover", activeLink));
 
/* menu toggle*/ 

let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");
let top_bar = document.getElementById("top_bar");

toggle.onclick = function () {
    navigation.classList.toggle("active");
    main.classList.toggle("active");
     if (navigation.classList.contains("active")) {
            top_bar.style.gap = "26%";
     } else {
            top_bar.style.gap = "19%";
     }
}


  const notificationPopup = document.getElementById("notificationPopup");
  const submitButton = document.querySelector(".contact-btn");
  const closeButton = document.getElementById("close-n");

  // Show the popup when the "submit" button is clicked
  submitButton.addEventListener("click", function () {
    notificationPopup.style.display = "block";
  });

  // Hide the popup when the "close" button is clicked
  closeButton.addEventListener("click", function () {
    notificationPopup.style.display = "none";
  });




  const toolPopup = document.getElementById("tool-registration-Popup");
  const recButton = document.querySelector(".rec-button");
  const close_t = document.getElementById("close-t");

  // Show the popup when the "submit" button is clicked
  recButton.addEventListener("click", function () {
    toolPopup.style.display = "block";
  });

  // Hide the popup when the "close" button is clicked
  close_t.addEventListener("click", function () {
    toolPopup.style.display = "none";
  });


    const file_Popup = document.getElementById("rec-file-popup");
    const rerfile= document.querySelector(".upload-file-btn");
    const close_f = document.getElementById("close-f");

    // Show the popup when the "submit" button is clicked
    rerfile.addEventListener("click", function () {
      file_Popup.style.display = "block";
    });

    // Hide the popup when the "close" button is clicked
    close_f.addEventListener("click", function () {
      file_Popup.style.display = "none";
    });



    const project_Popup = document.getElementById("popup-project");
    const add_p = document.querySelector(".add-proj");
    const close_p = document.getElementById("close-p");

    // Show the popup when the "submit" button is clicked
     add_p.addEventListener("click", function () {
      project_Popup.style.display = "block";
    });

    // Hide the popup when the "close" button is clicked
    close_p.addEventListener("click", function () {
      project_Popup.style.display = "none";
    });

        const member_Popup = document.getElementById("popup_member");
        const add_m = document.querySelector(".member-btn");
        const close_member = document.getElementById("close-member");

        // Show the popup when the "submit" button is clicked
         add_m.addEventListener("click", function () {
         member_Popup.style.display = "block";
        });

        // Hide the popup when the "close" button is clicked
        close_member.addEventListener("click", function () {
          member_Popup.style.display = "none";
        });
