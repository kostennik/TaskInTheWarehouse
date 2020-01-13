/********************************************************************
 jquery-fake-loader
 *Version:    2.0.0 - 2019
 *author:     João Pereira
 *website:    http://www.joaopereira.pt
 *Licensed MIT
 ********************************************************************/
(function ($) {
  $.fakeLoader = function(options) {

    let settings = $.extend({
      targetClass:'fakeLoader',
      timeToHide:1200,
      bgColor: '#2ecc71',
      spinner:'spinner2'
    }, options);

    let spinner01 = '<div class="fl fl-spinner spinner1"><div class="double-bounce1"></div><div class="double-bounce2"></div></div>';
    let spinner02 = '<div class="fl fl-spinner spinner2"><div class="spinner-container container1"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div><div class="spinner-container container2"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div><div class="spinner-container container3"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div></div>';
    let spinner03 = '<div class="fl fl-spinner spinner3"><div class="dot1"></div><div class="dot2"></div></div>';
    let spinner04 = '<div class="fl fl-spinner spinner4"></div>';
    let spinner05 = '<div class="fl fl-spinner spinner5"><div class="cube1"></div><div class="cube2"></div></div>';
    let spinner06 = '<div class="fl fl-spinner spinner6"><div class="rect1"></div><div class="rect2"></div><div class="rect3"></div><div class="rect4"></div><div class="rect5"></div></div>';
    let spinner07 = '<div class="fl fl-spinner spinner7"><div class="circ1"></div><div class="circ2"></div><div class="circ3"></div><div class="circ4"></div></div>';

    let el = $('body').find('.' + settings.targetClass);

    el.each(function() {
      let a = settings.spinner;

      switch (a) {
        case 'spinner1':
          el.html(spinner01);
          break;
        case 'spinner2':
          el.html(spinner02);
          break;
        case 'spinner3':
          el.html(spinner03);
          break;
        case 'spinner4':
          el.html(spinner04);
          break;
        case 'spinner5':
          el.html(spinner05);
          break;
        case 'spinner6':
          el.html(spinner06);
          break;
        case 'spinner7':
          el.html(spinner07);
          break;
        default:
          el.html(spinner01);
      }
    });

    el.css({
      'backgroundColor':settings.bgColor
    });

    setTimeout(function () {
      $(el).fadeOut();
    }, settings.timeToHide);
  };
}(jQuery));