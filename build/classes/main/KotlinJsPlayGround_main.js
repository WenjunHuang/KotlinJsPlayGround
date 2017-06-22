define('KotlinJsPlayGround_main', ['exports', 'kotlin', 'kotlinx-html-js'], function (_, Kotlin, $module$kotlinx_html_js) {
  'use strict';
  var span = $module$kotlinx_html_js.kotlinx.html.span_6djfml$;
  var div = $module$kotlinx_html_js.kotlinx.html.div_59el9d$;
  var append = $module$kotlinx_html_js.kotlinx.html.dom.append_k9bwru$;
  function sayHi$lambda$lambda$lambda($receiver) {
    $receiver.unaryPlus_pdl1vz$('Hello');
  }
  function sayHi$lambda$lambda($receiver) {
    span($receiver, void 0, sayHi$lambda$lambda$lambda);
  }
  function sayHi$lambda($receiver) {
    div($receiver, void 0, sayHi$lambda$lambda);
  }
  function sayHi() {
    var tmp$;
    append((tmp$ = document.body) != null ? tmp$ : Kotlin.throwNPE(), sayHi$lambda);
  }
  var package$simple = _.simple || (_.simple = {});
  package$simple.sayHi = sayHi;
  Kotlin.defineModule('KotlinJsPlayGround_main', _);
  return _;
});

//@ sourceMappingURL=KotlinJsPlayGround_main.js.map
