webpackJsonp([22], {
	"+Bml": function(s, t, a) {
		var e = a("VU/8")(a("w0Cj"), a("wN/g"), !1, null, null, null);
		s.exports = e.exports
	},
	w0Cj: function(s, t, a) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		}), t.default = {
			props: ["documentId"],
			mixins: [a("Uv0U")],
			data: function() {
				return {
					form: new SparkForm({
						password: ""
					})
				}
			},
			mounted: function() {},
			methods: {
				submit: function() {
					Spark.post("/" + this.documentId + "/password", this.form).then(function(s) {
						window.location = s.redirect
					})
				}
			}
		}
	},
	"wN/g": function(s, t) {
		s.exports = {
			render: function() {
				var s = this,
					t = s.$createElement,
					a = s._self._c || t;
				return a("div", {
					staticClass: "admin-form theme-info mw500 center-block center-children mt50"
				}, [a("div", {
					staticClass: "panel  panel-primary heading-border"
				}, [a("div", {
					staticClass: "panel-heading"
				}, [a("span", {
					staticClass: "panel-title"
				}, [a("i", {
					staticClass: "fa fa-lock"
				}), s._v(" " + s._s(s._f("trans")("app.enterpassword")) + " ")])]), s._v(" "), a("div", {
					staticClass: "panel-body p25"
				}, [a("div", {
					staticClass: "section row"
				}, [a("label", {
					staticClass: "field-label"
				}, [s._v(" " + s._s(s._f("trans")("app.password")) + " ")]), s._v(" "), a("label", {
					staticClass: "field prepend-icon",
					class: ["field", "prepend-icon", {
						"state-error": s.form.errors.has("password")
					}],
					attrs: {
						for: "password"
					}
				}, [a("input", {
					directives: [{
						name: "model",
						rawName: "v-model",
						value: s.form.password,
						expression: "form.password"
					}],
					staticClass: "gui-input",
					attrs: {
						placeholder: s.$options.filters.trans("app.enterpasswordtext"),
						id: "password",
						name: "password",
						type: "password"
					},
					domProps: {
						value: s.form.password
					},
					on: {
						input: function(t) {
							t.target.composing || (s.form.password = t.target.value)
						}
					}
				}), s._v(" "), s._m(0)]), s._v(" "), a("em", {
					directives: [{
						name: "show",
						rawName: "v-show",
						value: s.form.errors.has("password"),
						expression: "form.errors.has('password')"
					}],
					staticClass: "state-error"
				}, [s._v("\n                    " + s._s(s.form.errors.get("password")) + "\n                ")])])]), s._v(
					" "), a("div", {
					staticClass: "panel-footer clearfix"
				}, [a("button", {
					staticClass: "button btn-primary pull-right",
					attrs: {
						disabled: s.form.busy
					},
					on: {
						click: function(t) {
							t.preventDefault(), s.submit()
						}
					}
				}, [s._v("\n                " + s._s(s._f("trans")("app.ok")) + "\n            ")])])])])
			},
			staticRenderFns: [function() {
				var s = this.$createElement,
					t = this._self._c || s;
				return t("label", {
					staticClass: "field-icon",
					attrs: {
						for: "password"
					}
				}, [t("i", {
					staticClass: "fa fa-lock"
				})])
			}]
		}
	}
});
