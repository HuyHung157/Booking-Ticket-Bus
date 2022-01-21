/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
  $(".owl-carousel").owlCarousel({
    /**
    * owl carousel cloned prev/next blocks to allow infinite loop,
    * so you must to init canvas after every change
    * 
    * P.S. change event fires also on owl carousel init, so no need to init canvas before
    */
    onChanged: function(e) {
      progressSim('.my_canvas');
    },

    loop:true,
    margin:20,
    nav:true,
    dots:true,
    navText:[
        "<div class='btn-slide prev-slide'><i class='fa fa-chevron-left'></i></div>",
        "<div class='btn-slide next-slide'><i class='fa fa-chevron-right'></i></div>"
    ],
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:1
        }
    }
  });
});

/* CANVAS JS */
function progressSim(selector) {
  $(selector).each(function() {
    const $item = $(this);

    // prevent double initializetion of canvas
    if ($item.data('initilized') === true) {
      return;
    }

    const percent = $item.data('percent');

    let ctx = $item.get(0).getContext('2d'),
        cw = ctx.canvas.width,
        ch = ctx.canvas.height,
        al = 0,
        sim = setInterval(progress, 25);

    // mark already initialized canvases to prevent double init
    $item.data('initilized', true);

    function progress() {
      let start = 4.72,
          diff = ((al / 100) * Math.PI * 2 * 10).toFixed(2);

      ctx.clearRect(0, 0, cw, ch);
      ctx.lineWidth = 7;
      ctx.fillStyle = '#000';
      ctx.strokeStyle = "#000";
      ctx.textAlign = 'center';
      ctx.font="30px Arial";
      ctx.fillText(al + '%', cw * .5, ch * .5 + 2, cw);
      ctx.beginPath();
      ctx.arc(80, 80, 70, start, diff / 10 + start, false);
      ctx.stroke();
      if (al >= percent) {
        clearTimeout(sim);
        // Add scripting here that will run when progress completes
      }
      al++;
    };
  })        
}

