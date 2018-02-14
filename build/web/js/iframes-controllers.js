/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Resizes all the iframe objects on the current page. This is called when
 * the page is loaded. For some reason using jQuery to trigger on loading
 * the iframe does not work in Firefox 26.
 */
window.onload = function () {
    var frame;
    var frames = window.parent.document.getElementsByTagName('iframe');
    var i = frames.length - 1;
    while (i >= 0) {
        frame = frames[i];
        frame.onload = resize(frame);
        i -= 1;
    }
};

function resize(frame) {
    var b = frame.contentWindow.document.body || frame.contentDocument.body; 
    var cHeight = ($(b).height()) + 100;
    if (frame.oHeight !== cHeight) {
        $(frame).height(0);
        frame.style.height = 0;
        $(frame).height(cHeight);
        frame.style.height = cHeight + "px";
        frame.oHeight = cHeight;
    }

    // Call again to check whether the content height has changed.
    /*setTimeout(function () {
        resize(frame);
    }, 250);*/
}
