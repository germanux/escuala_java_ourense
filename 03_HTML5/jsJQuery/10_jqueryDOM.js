// jQuery(...) se abrevia como $(...)
jQuery(document).ready(function() {
    
    jQuery("section").append("<div><p>LEYENDA DE LO QUE SEA</p></div>");
    $(".articulo").append("<p>UN PARRAFO EN CADA ELEM con class = 'articulo'</p>");
    
    $("tr").append("<td>Info</td>");    // Añadir quinta col
    // tr.setAttribute("style", "background-color: red");
    $("td:nth-child(5)").attr("style", "background-color: red; color: white");
    $("td:nth-child(5)").click(() => { 
        alert('un click desde jQ' );
    } );
    $("#otro_menu").append("<p>.....</p><br/><br/>");
    $("#otro_menu").click(function() {
        // $("#otro_menu").fadeOut();
        $(this).slideUp();
    });


    // Evento hover()
});
