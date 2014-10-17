$(document).ready(function () {
    $("body").fadeIn();
    $(".slide-menu-item-container").mouseenter(function () {
        $(this).addClass("slide-menu-item-container-hover");
    });
    $(".slide-menu-item-container").mouseleave(function () {
        $(this).removeClass("slide-menu-item-container-hover");
    });
});
function toggleMenu() {
    $(".slide-menu").stop().slideToggle();
}


