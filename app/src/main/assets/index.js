// { "framework": "Vue"}

/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 3);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */,
/* 1 */,
/* 2 */,
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _index = __webpack_require__(4);

var _index2 = _interopRequireDefault(_index);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

_index2.default.el = '#root';
new Vue(_index2.default);

/***/ }),
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = []

/* styles */
__vue_styles__.push(__webpack_require__(5)
)

/* script */
__vue_exports__ = __webpack_require__(6)

/* template */
var __vue_template__ = __webpack_require__(7)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}
__vue_options__.__file = "D:\\weex\\test2\\src\\index.vue"
__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
__vue_options__._scopeId = "data-v-1a4d8e3c"
__vue_options__.style = __vue_options__.style || {}
__vue_styles__.forEach(function (module) {
  for (var name in module) {
    __vue_options__.style[name] = module[name]
  }
})
if (typeof __register_static_styles__ === "function") {
  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
}

module.exports = __vue_exports__


/***/ }),
/* 5 */
/***/ (function(module, exports) {

module.exports = {
  "header": {
    "height": "80",
    "width": "750",
    "backgroundColor": "#000000",
    "flexDirection": "row"
  },
  "header_symbol": {
    "height": "60",
    "width": "300",
    "marginTop": "10"
  },
  "header_percent": {
    "height": "40",
    "width": "40",
    "marginTop": "20",
    "marginLeft": "320"
  },
  "header_register": {
    "height": "40",
    "width": "40",
    "marginTop": "20",
    "marginLeft": 30
  },
  "city": {
    "height": "200",
    "width": "710",
    "marginTop": "20",
    "marginLeft": "20",
    "marginRight": "20",
    "backgroundColor": "#bbbbbb"
  },
  "citytext": {
    "fontSize": "36",
    "marginTop": "5",
    "marginLeft": "5",
    "marginRight": "5",
    "width": "340"
  },
  "citytext2": {
    "fontSize": "24",
    "marginTop": "5",
    "marginLeft": "5",
    "marginRight": "5",
    "minWidth": "100"
  },
  "panel": {
    "width": "700",
    "height": "250",
    "marginLeft": "25",
    "marginTop": "35",
    "marginBottom": "35",
    "flexDirection": "column",
    "borderWidth": "2",
    "borderStyle": "solid",
    "borderColor": "rgb(162,217,192)",
    "backgroundColor": "rgba(162,217,192,0.2)"
  },
  "text": {
    "fontSize": "50",
    "textAlign": "center",
    "color": "#000000"
  }
}

/***/ }),
/* 6 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

var modal = weex.requireModule('modal');
var stream = weex.requireModule('stream');
exports.default = {
  name: 'App',
  components: {},
  data: function data() {
    return {
      info: {},
      fc: []
    };
  },
  created: function created() {
    var _this = this;

    var url = 'https://www.sojson.com/open/api/weather/json.shtml?city=北京';
    this.getNews(url, function (res) {
      //modal.toast({message:'请求成功'+res.date.toString(),duration:1});
      _this.info = res.data;
      //this.fc=res.data.forecast;
      //console.log("lalalala"+this.fc);
    });
  },

  methods: {
    getNews: function getNews(url, callback) {
      return stream.fetch({
        method: 'GET',
        type: 'json',
        url: url
      }, callback);
    }
  }
};

/***/ }),
/* 7 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticStyle: {
      backgroundColor: "#dddddd"
    }
  }, [_vm._m(0), _c('div', {
    staticClass: ["city"]
  }, [_c('div', {
    staticStyle: {
      flexDirection: "row"
    }
  }, [_c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("城市：" + _vm._s(_vm.info.city))]), _c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("日期：" + _vm._s(_vm.info.date))])]), _c('div', {
    staticStyle: {
      flexDirection: "row"
    }
  }, [_c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("温度：" + _vm._s(_vm.info.data.wendu))]), _c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("湿度：" + _vm._s(_vm.info.data.shidu))])]), _c('div', {
    staticStyle: {
      flexDirection: "row"
    }
  }, [_c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("pm2.5：" + _vm._s(_vm.info.data.pm25))]), _c('text', {
    staticClass: ["citytext"]
  }, [_vm._v("pm10：" + _vm._s(_vm.info.data.pm10))])]), _c('div', {
    staticStyle: {
      flexDirection: "row"
    }
  }, [_c('text', {
    staticClass: ["citytext2"]
  }, [_vm._v("空气质量：" + _vm._s(_vm.info.data.quality))]), _c('text', {
    staticClass: ["citytext2"]
  }, [_vm._v("感冒指数：" + _vm._s(_vm.info.data.ganmao))])])]), _c('list', _vm._l((this.info.data.forecast), function(news) {
    return _c('cell', {
      appendAsTree: true,
      attrs: {
        "append": "tree"
      }
    }, [_c('div', {
      staticClass: ["panel"]
    }, [_c('div', {
      staticStyle: {
        flexDirection: "row"
      }
    }, [_c('text', {
      staticClass: ["citytext"]
    }, [_vm._v(_vm._s(news.date))]), _c('text', {
      staticClass: ["citytext"]
    }, [_vm._v(_vm._s(news.type))])]), _c('div', {
      staticStyle: {
        flexDirection: "row"
      }
    }, [_c('text', {
      staticClass: ["citytext"]
    }, [_vm._v(_vm._s(news.high))]), _c('text', {
      staticClass: ["citytext"]
    }, [_vm._v(_vm._s(news.low))])]), _c('div', {
      staticStyle: {
        flexDirection: "row"
      }
    }, [_c('text', {
      staticClass: ["citytext"]
    }, [_vm._v("风向：" + _vm._s(news.fx))]), _c('text', {
      staticClass: ["citytext"]
    }, [_vm._v("风力：" + _vm._s(news.fl))])]), _c('text', {
      staticClass: ["citytext"]
    }, [_vm._v(_vm._s(news.notice))])])])
  }))])
},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: ["header"]
  }, [_c('image', {
    staticClass: ["header_symbol"],
    attrs: {
      "resize": "contain",
      "src": "http://f.gamer.qq.com/v2/h5/static/build/base-xlab-logo2-5699a6319b.png"
    }
  }), _c('image', {
    staticClass: ["header_percent"],
    attrs: {
      "resize": "contain",
      "src": "http://f.gamer.qq.com/v2/h5/static/build/help-icon-percent-f55e800125.png"
    }
  }), _c('image', {
    staticClass: ["header_register"],
    attrs: {
      "resize": "contain",
      "src": "http://f.gamer.qq.com/v2/h5/static/build/help-icon-register-17aafe6ed7.png"
    }
  })])
}]}
module.exports.render._withStripped = true

/***/ })
/******/ ]);