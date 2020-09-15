clickMenu = function(menu) {
        let getEls = document.getElementById(menu).getElementsByTagName("LI");
        const getAgn = getEls;
        for (let i=0; i<getEls.length; i++) {
            getEls[i].onclick=function() {
                for (let x=0; x<getAgn.length; x++) {
                    getAgn[x].className=getAgn[x].className.replace("unclick", "");
                    getAgn[x].className=getAgn[x].className.replace("click", "unclick");
                }
                if ((this.className.indexOf('unclick'))!==-1) {
                    this.className = this.className.replace("unclick", "");
                }
                else {
                    this.className+=" click";
                }
            };
            getEls[i].onmouseover=function() {
                this.className+=" hover";
            };
            getEls[i].onmouseout=function() {
                this.className=this.className.replace("hover", "");
            }
        }
    }

