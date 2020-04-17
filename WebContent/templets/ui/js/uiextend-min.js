function DynamicTree(D, g) {
	var y = this;
	var m = $(D);
	var A = null;
	var r = null;
	var s = {
		loadtype : 1,
		viewField : "_text"
	};
	function e() {
		$.extend(s, {
			datasetName : m.attr("componentdataset"),
			contextmenu : m.attr("contextmenu")
		})
	}
	function n() {
		e();
		var F = $.extend(s, g || {});
		var E = m;
		var H = F.datasetName;
		A = getDatasetByID(H);
		var G = F.contextmenu;
		A.init = false;
		r = copyDataset(H + new Date().getTime(), H);
		r.flushData(1);
		E.tree({
			cascadeCheck : false,
			data : r,
			loader : function(L, K, I) {
				r.setParameter("_id", L.id);
				r.flushData(1);
				var J = E.tree("options");
				J.cascadeCheck = false;
				K(r);
				r.setParameter("_id", null)
			},
			loadFilter : function(I) {
				return treedataset2json(I, F)
			},
			onLoadSuccess : function(J, K) {
				var I = E.tree("options");
				I.cascadeCheck = true
			},
			onContextMenu : function(J, I) {
				J.preventDefault();
				y.rightSelectedNode = I;
				if (y.supportRightClick && G) {
					$(G).menu("show", {
						left : J.pageX,
						top : J.pageY,
						data : {
							tree : E,
							node : I,
							record : I.attributes.record
						}
					})
				}
			},
			onBeforeCollapse : function(J) {
				var I = E.attr("id") + "_beforeCollapseNode";
				if (isUserEventDefined(I)) {
					var K = fireUserEvent(I, [ E, J ]);
					if (!K) {
						return false
					}
				}
			},
			onCollapse : function(J) {
				var I = E.attr("id") + "_afterCollapseNode";
				fireUserEvent(I, [ E, J ])
			},
			onBeforeExpand : function(J) {
				var I = E.attr("id") + "_beforeExpandNode";
				if (isUserEventDefined(I)) {
					var K = fireUserEvent(I, [ E, J ]);
					if (!K) {
						return false
					}
				}
			},
			onExpand : function(J) {
				var I = E.attr("id") + "_afterExpandNode";
				fireUserEvent(I, [ E, J ])
			},
			onSelect : function(J) {
				if ((y.selectedNode && y.selectedNode.id != J.id)
						|| (!y.selectedNode)) {
					var I = E.attr("id") + "_onSelectionChanged";
					fireUserEvent(I, [ E, J, y.selectedNode ]);
					y.selectedNode = J
				}
				var I = E.attr("id") + "_onSelect";
				fireUserEvent(I, [ E, J ])
			},
			onBeforeCheck : function(K, J) {
				var I = E.attr("id") + "_onBeforeCheck";
				if (isUserEventDefined(I)) {
					var L = fireUserEvent(I, [ E, K, J ]);
					if (!L) {
						return false
					}
				}
			},
			onCheck : function(K, J) {
				var I = E.attr("id") + "_onCheck";
				fireUserEvent(I, [ E, K, J ])
			}
		})
	}
	function B(E) {
		return m.tree("getChecked", E)
	}
	function h(F) {
		var E = m.tree("find", F);
		return E || {}
	}
	function a(F) {
		var E = h(F);
		m.tree("select", E.target)
	}
	function t(F) {
		var E = h(F);
		m.tree("check", E.target)
	}
	function k(F) {
		var E = h(F);
		m.tree("uncheck", E.target)
	}
	function j(F) {
		var E = h(F);
		m.tree("collapse", E.target)
	}
	function o(F) {
		var E = h(F);
		m.tree("expand", E.target)
	}
	function b(F) {
		var E = h(F);
		m.tree("toggle", E.target)
	}
	function v(F) {
		var E = h(F);
		m.tree("collapseAll", E.target)
	}
	function w(F) {
		var E = h(F);
		m.tree("expandAll", E.target)
	}
	function f(G, F) {
		var E = h(G);
		m.tree("append", {
			parent : E.target,
			data : F
		})
	}
	function q(H, E, G) {
		var F = h(H);
		if (G == "before") {
			m.tree("insert", {
				before : F.target,
				data : E
			})
		} else {
			m.tree("insert", {
				after : F.target,
				data : E
			})
		}
	}
	function l(F) {
		var E = h(F);
		return m.tree("pop", E.target)
	}
	function i(F) {
		var E = h(F);
		return m.tree("isLeaf", E.target)
	}
	function p() {
		return m.tree("getSelected")
	}
	function x(F) {
		var E = h(F);
		return m.tree("getParent", E.target)
	}
	function d() {
		return m.tree("getRoot")
	}
	function C() {
		return m.tree("getRoots")
	}
	function c(H) {
		var F = h(H);
		var E = m.attr("id") + "_onBeforeRefresh";
		if (isUserEventDefined(E)) {
			var G = fireUserEvent(E, [ m, F ]);
			if (!G) {
				return false
			}
		}
		m.tree("reload", F.target);
		E = m.attr("id") + "_onRefresh";
		fireUserEvent(E, [ m, F ])
	}
	function u(E) {
		return m.tree("options")
	}
	function z(G, F) {
		var E = h(G);
		F = F || {};
		m.tree("update", {
			target : E.target,
			text : F.text
		})
	}
	this.id = $(D).attr("id");
	this.rightSelectedNode = null;
	this.selectedNode = null;
	this.supportRightClick = true;
	this.targetFrame = null;
	this.topNode = m.tree("getRoot");
	this.getChecked = function() {
		return B()
	};
	this.getUnChecked = function() {
		return B("unchecked")
	};
	this.getIndeterminate = function() {
		return B("indeterminate")
	};
	this.find = h;
	this.select = a;
	this.selectAll = function() {
		var E = C();
		for (var F = 0; F < E.length; F++) {
			t(E[F].id)
		}
	};
	this.unSelectAll = function() {
		var E = C();
		for (var F = 0; F < E.length; F++) {
			k(E[F].id)
		}
	};
	this.check = t;
	this.uncheck = k;
	this.collapse = j;
	this.expand = o;
	this.toggle = b;
	this.collapseAll = v;
	this.expandAll = w;
	this.append = f;
	this.insert = q;
	this.remove = l;
	this.isLeaf = i;
	this.getSelected = p;
	this.getParent = x;
	this.getRoot = d;
	this.getRoots = C;
	this.refresh = c;
	this.options = u;
	n()
}
function DynamicTabSet(a, r) {
	var e = this;
	var h = $(a);
	var j = {};
	var z = 1;
	var E = null;
	var q = null;
	var P = false;
	var i = {};
	var G = {};
	var y = {
		title : "&nbsp",
		fit : true,
		init : true,
		isHaveNavigate : false,
		contextMenu : true,
		onSelectNavigate : function(R, T) {
			if (!R.isHaveNavigate && !R.isComplete) {
				return
			}
			if (T.isHaveNavigate) {
				var Q = $("ul.tabs li.tabs-selected").width();
				$("ul.tabs li.tabs-selected span.tabs-click").css("left", 0)
						.width(Q);
				var S;
				$(
						"div.tabs-container div.tabs-header div.tabs-wrap ul.tabs li.tabs-selected a.tabs-inner span.tabs-click")
						.hover(
								function(aa) {
									$(".tabs li.tabs-selected a.tabs-inner",
											this).addClass("navigate");
									var Y = $("div.tabs-container div.tabs-panels div:visible");
									var X = $("div.navigate-div", Y);
									if (X.length == 0) {
										var ab = new Array();
										ab.push('<div class="navigate-div">');
										ab.push('<ul class="nav">');
										if (R.rootId) {
											ab.push('<li class="normal">');
											ab.push("<a class=''><span>"
													+ R.rootId + "</span></a>");
											ab.push("</li>");
											ab
													.push('<li class="arrow_hleft">&nbsp;</li>')
										}
										for (var Z = 0; Z < R.history.length; Z++) {
											var W = R.history[Z].url;
											if (Z == (R.history.length - 1)) {
												if (W.indexOf(".ftl") != -1) {
													if (Z % 2 == 0) {
														ab
																.push('<li class="hlight">')
													} else {
														ab
																.push('<li class="normal">')
													}
													ab
															.push("<a class='current-iframe' href=\"javascript:void(0);\" onclick=\"dts.refresh('','"
																	+ W
																	+ "');$('div.navigate-div').remove();$('.tabs li.tabs-selected a.tabs-inner').removeClass('navigate');\"><span>"
																	+ (R.history[Z].title || R.desc)
																	+ "</span></a>");
													ab.push("</li>");
													if (Z % 2 == 0) {
														ab
																.push('<li class="arrow_wright">&nbsp;</li>')
													} else {
														ab
																.push(' <li class="arrow_bright">&nbsp;</li>')
													}
												} else {
													if (Z % 2 == 0) {
														ab
																.push('<li class="hlight">')
													} else {
														ab
																.push('<li class="normal">')
													}
													ab
															.push("<a class='current-iframe'><span>"
																	+ (R.history[Z].title || R.desc)
																	+ "</span></a>");
													ab.push("</li>");
													if (Z % 2 == 0) {
														ab
																.push('<li class="arrow_wright">&nbsp;</li>')
													} else {
														ab
																.push(' <li class="arrow_bright">&nbsp;</li>')
													}
												}
												continue
											}
											if (W.indexOf(".ftl") != -1) {
												if (Z % 2 == 0) {
													ab
															.push('<li class="hlight">')
												} else {
													ab
															.push('<li class="normal">')
												}
												ab
														.push("<a class='' href=\"#\" onclick=\"dts.refresh('','"
																+ W
																+ "');$('div.navigate-div').remove();$('.tabs li.tabs-selected a.tabs-inner').removeClass('navigate');\"><span>"
																+ (R.history[Z].title || R.desc)
																+ "</span></a>");
												ab.push("</li>");
												if (Z % 2 == 0) {
													ab
															.push('<li class="arrow_hright">&nbsp;</li>')
												} else {
													ab
															.push('<li class="arrow_hleft">&nbsp;</li>')
												}
											} else {
												if (Z % 2 == 0) {
													ab
															.push('<li class="hlight">')
												} else {
													ab
															.push('<li class="normal">')
												}
												ab
														.push("<a class=''><span>"
																+ (R.history[Z].title || R.desc)
																+ "</span></a>");
												ab.push("</li>");
												if (Z % 2 == 0) {
													ab
															.push('<li class="arrow_hright">&nbsp;</li>')
												} else {
													ab
															.push('<li class="arrow_hleft">&nbsp;</li>')
												}
											}
										}
										ab.push("</ul></div>");
										var U = $(ab.join(""));
										var V = aa || event;
										var ac = V.clientX
												+ document.body.scrollLeft
												+ -40 + "px";
										U.css("left", ac);
										$("a.menu-search", U).hover(function() {
										}, function() {
										});
										var ad = $("li", U);
										if (ad.length == 2) {
											return
										}
										U
												.prependTo(
														"div.tabs-container div.tabs-panels div.panel:visible")
												.show(300);
										$("div.navigate-div")
												.hover(
														function() {
															clearTimeout(S)
														},
														function() {
															$(
																	"div.navigate-div")
																	.remove();
															$(
																	".tabs li.tabs-selected a.tabs-inner")
																	.removeClass(
																			"navigate")
														})
									}
								},
								function() {
									S = setTimeout(
											function() {
												$("div.navigate-div").remove();
												$(
														".tabs li.tabs-selected a.tabs-inner")
														.removeClass("navigate")
											}, 200)
								})
			}
		},
		onContextMenu : function(R, Q) {
			if (!L().contextMenu) {
				return
			}
			if (!E) {
				var S = $('<div class="tabs-contextmenu"/>').width(120)
						.appendTo($("body"));
				$('<div name="menuitem_close" />').text(
						$.fn.tabs.defaults.m_close).appendTo(S);
				$('<div name="menuitem_closeall" />').text(
						$.fn.tabs.defaults.m_closeAll).appendTo(S);
				$('<div name="menuitem_closeother" />').text(
						$.fn.tabs.defaults.m_closeOther).appendTo(S);
				$('<div class="menu-sep" />').appendTo(S);
				$('<div name="menuitem_closeright" />').text(
						$.fn.tabs.defaults.m_closeRight).appendTo(S);
				$('<div name="menuitem_closeleft" />').text(
						$.fn.tabs.defaults.m_closeLeft).appendTo(S);
				$('<div class="menu-sep" />').appendTo(S);
				$('<div name="menuitem_refresh" />').text(
						$.fn.tabs.defaults.m_refresh).appendTo(S);
				S.menu({
					onClick : function(T) {
						var U = E.data("current-id");
						switch (T.name) {
						case "menuitem_close":
							F(U);
							break;
						case "menuitem_closeall":
							I();
							break;
						case "menuitem_closeother":
							N(U);
							break;
						case "menuitem_closeright":
							C(U);
							break;
						case "menuitem_closeleft":
							n(U);
							break;
						case "menuitem_refresh":
							o(U);
							break
						}
					}
				});
				E = S
			}
			E.data("current-id", Q.title);
			_contextmenu_onfilter(E, e, Q);
			E.menu("show", {
				left : R.pageX,
				top : R.pageY
			});
			return false
		},
		onBeforeSelect : function(R, Y) {
			if (top.pageloading) {
				return false
			}
			$(
					"div.tabs-container div.tabs-wrap ul.tabs li.tabs-selected a.tabs-inner span.tabs-click")
					.unbind("mouseenter mouseleave");
			if (!P || L().disableEvent) {
				return
			}
			var Q = B(0);
			if (R == Q) {
				return
			}
			var W = h.attr("id") + "_beforeTabChange";
			if (isUserEventDefined(W)) {
				var T = fireUserEvent(W, [ e, Q, R ]);
				if (T) {
					if (T == true) {
					} else {
						errAlert(T)
					}
					return false
				}
			} else {
				var S = M(Q);
				if (S) {
					var V = S.find("iframe")[0];
					if (V) {
						var U = V.contentWindow;
						try {
							if (U.fireUserEvent) {
								var T = U.fireUserEvent(W, [ e, Q, R ]);
								if (T == false) {
									return false
								}
							}
						} catch (X) {
							errAlert(X);
							return false
						}
					}
				}
			}
			return true
		},
		onSelect : function(U) {
			if (!P) {
				return
			}
			var S = false;
			function T() {
				S = true;
				var Z = R.find("div.tabcontent-iframe");
				var aa = Z.size() == 0;
				if (!aa) {
					var Y = "_frame_" + U + "_" + guidGenerator();
					var X = getUrl(Z.attr("url"));
					var ad = unwrapUrl(X);
					var ab = wrapUrl(ad[0], $.extend({}, i, ad[1], g()));
					var ae = (h.attr("id") || "_undefined");
					_topmask();
					Z
							.after('<iframe id="'
									+ Y
									+ '" scrolling="auto" frameborder="0" src="'
									+ ab
									+ '" url="'
									+ ab
									+ '" style="width:100%;height:100%;" onload="_topmask(0);eval(\'contentWindow.'
									+ ae
									+ "="
									+ ae
									+ ";');\" onfocus=\"if(typeof(focusFrame) == 'function'){focusFrame();}\"></iframe>");
					Z.remove()
				} else {
					var W = R.find("iframe");
					var V = W.attr("src");
					var X = W.attr("url");
					if (U != Q) {
						var ac = V;
						var ad = unwrapUrl(X);
						var af = wrapUrl(ad[0], $.extend({}, i, ad[1], g()));
						if (af != ac) {
							_topmask();
							W.attr("src", af);
							W.attr("url", af)
						}
					}
				}
				Z = null;
				R = null;
				q = null
			}
			var R = w();
			var Q = B(1);
			if (typeof (changeSession) == "function"
					&& typeof (R.attr("_ticket_")) != "undefined") {
				changeSession(R.attr("_ticket_"));
				T()
			} else {
				if (q) {
					clearTimeout(q)
				}
				q = setTimeout(T, 200)
			}
		},
		onAfterSelect : function(X, V) {
			if (!P || L().disableEvent) {
				return
			}
			e.selectName = K();
			e.selectIndex = s();
			e.selectTab = w();
			if (e.selectTab) {
				e.selectTab.name = e.selectName
			}
			var S = B(1);
			if (X == S) {
				return
			}
			var Q = h.attr("id") + "_afterTabChange";
			if (isUserEventDefined(Q)) {
				fireUserEvent(Q, [ e, S, X ])
			} else {
				var U = M(X);
				if (U) {
					var R = U.find("iframe")[0];
					if (R) {
						var W = R.contentWindow;
						try {
							if (W.fireUserEvent) {
								W.fireUserEvent(Q, [ e, S, X ])
							}
						} catch (T) {
						}
					}
				}
			}
		},
		onAdd : function(U, R) {
			if (!P) {
				return
			}
			try {
				PrivAction.setCurrentTabId(U)
			} catch (T) {
			}
			var S = M(U);
			var Q = S.panel("options");
			if (Q.ticket) {
				S.attr("_ticket_", ticket)
			} else {
				S.attr("_ticket_", guidGenerator())
			}
			$(".tabs li", h).each(function() {
				$(this).hover(function() {
					$("a.tabs-close", $(this)).css("display", "block")
				}, function() {
					$("a.tabs-close", $(this)).css("display", "none")
				})
			})
		},
		onBeforeClose : function(V, S) {
			if (!P || L().disableEvent) {
				return
			}
			var T = M(V);
			var U = T.attr("_ticket_");
			if (typeof (clearSession) == "function"
					&& typeof (U) != "undefined") {
				clearSession(U)
			}
			var R = h.attr("id") + "_beforeTabClose";
			if (isUserEventDefined(R)) {
				var Q = fireUserEvent(R, [ j, V ]);
				if (Q == false) {
					return false
				}
			}
		},
		onClose : function(T, S) {
			if (!P || L().disableEvent) {
				return
			}
			var R = h.attr("id") + "_afterTabClose";
			if (isUserEventDefined(R)) {
				var Q = fireUserEvent(R, [ j, T ]);
				if (Q == false) {
					return false
				}
			}
		}
	};
	J();
	function u(Q) {
		if (Q == false || Q == "false") {
			return false
		} else {
			return true
		}
	}
	function L() {
		if (arguments.length == 0) {
			return j.tabs("options")
		} else {
			if (arguments.length == 1) {
				return j.tabs("options")[arguments[0]]
			} else {
				if (arguments.length == 2) {
					j.tabs("options")[arguments[0]] = arguments[1]
				}
			}
		}
	}
	function B(Q) {
		Q = Q || 0;
		var S = j.tabs("selectHis");
		var R = S.length - 1 - Q;
		return S[R]
	}
	function c(Q) {
		if (top.pageloading) {
			return false
		}
		j.tabs("select", Q)
	}
	function t(Q) {
		return j.tabs("exists", Q)
	}
	function H(S, R) {
		var Q = j.tabs("getTab", S);
		j.tabs("update", {
			tab : Q,
			options : R
		})
	}
	function v(R, Q) {
		Q ? j.tabs("enableTab", R) : j.tabs("disableTab", R)
	}
	function l(V, R) {
		var T = M(V).panel("options");
		var S = T.tab;
		var U = S.find("span.tabs-title");
		var Q = S.find("span.tabs-icon");
		Q.attr("class", "tabs-icon");
		if (R) {
			U.addClass("tabs-with-icon");
			Q.addClass(R)
		} else {
			U.removeClass("tabs-with-icon")
		}
		T.iconCls = R
	}
	function O(S, R) {
		var Q = M(S).panel("options");
		Q.tab.find("span.tabs-title").html(R);
		Q.desc = R
	}
	function k(W, T) {
		var Q = M(W);
		if (!Q) {
			return
		}
		var U = Q.panel("options");
		var S = U.tab;
		S.find("a.tabs-close").remove();
		var V = S.find("span.tabs-title");
		if (T) {
			V.addClass("tabs-closable");
			var R = $('<a href="javascript:void(0)" class="tabs-close"></a>')
					.appendTo(S);
			R.bind("click.tabs", {
				tabset : j,
				id : W,
				tab : Q
			}, function(X) {
				if ($(this).parent().hasClass("tabs-disabled")) {
					return
				}
				if (U.onCloseClick.call(this, X.data.tab) == false) {
					return
				}
				X.data.tabset.tabs("close", X.data.id);
				return false
			})
		} else {
			V.removeClass("tabs-closable")
		}
		U.closable = T
	}
	function b(Q) {
		return M(Q).panel("options").title
	}
	function w() {
		return j.tabs("getSelected")
	}
	function s() {
		return j.tabs("getTabIndex", w())
	}
	function K() {
		return w().panel("options").title
	}
	function M(Q) {
		return j.tabs("getTab", Q)
	}
	function m(Q) {
		return j.tabs("getTabIndex", M(Q))
	}
	function F(S) {
		if (top.pageloading) {
			return false
		}
		var Q = S == 0 ? 0 : (S || K());
		var R = M(Q).panel("options");
		if (_tabset_onBeforeClose(j, R.title, R.desc) == false) {
			return
		}
		j.tabs("close", Q)
	}
	function I() {
		$(j.tabs("tabs")).each(function() {
			var Q = $(this).panel("options").title;
			F(Q)
		})
	}
	function N(R) {
		var Q = R || K();
		$(j.tabs("tabs")).each(function() {
			var S = $(this).panel("options").title;
			if (S != Q) {
				F(S)
			}
		})
	}
	function C(T) {
		var R = T || K();
		var S = j.tabs("getTab", R);
		var Q = j.tabs("getTabIndex", S);
		$(j.tabs("tabs")).each(function(U) {
			if (U > Q) {
				F(Q + 1)
			}
		})
	}
	function n(T) {
		var R = T || K();
		var S = j.tabs("getTab", R);
		var Q = j.tabs("getTabIndex", S);
		while (--Q >= 0) {
			F(Q)
		}
	}
	function o(V, Q) {
		if (top.pageloading) {
			return false
		}
		var R = V == 0 ? 0 : (V || K());
		var S = j.tabs("getTab", R);
		var U = S.find("iframe");
		var T = U.attr("src") || "";
		if (U[0]) {
			_topmask();
			if (T.startWith(_application_root)) {
				destoryIframe($("iframe", U[0].contentWindow.document))
			}
			if (Q) {
				U[0].src = "about:blank";
				U[0].contentWindow.document.write("");
				U[0].contentWindow.close();
				Q = megerURL(_application_root, Q);
				U.attr("url", Q).attr("src", Q)
			} else {
				if (T.startWith(_application_root)) {
					U[0].contentWindow.location.reload(true)
				} else {
					U.attr("src", T)
				}
			}
		} else {
			if (Q) {
				S.find("div.tabcontent-iframe").attr("url", Q)
			}
		}
	}
	function A(V, U) {
		var T = V.split(",");
		var S = U.split(",");
		var Q = {};
		for (var R = 0; R < T.length; R++) {
			Q[T[R]] = S[R]
		}
		$.extend(G, Q)
	}
	function g() {
		var Q = $.extend({}, G);
		G = {};
		return Q
	}
	function p(Q) {
		i = Q
	}
	function D(Q) {
		L().contextMenu = Q
	}
	function f() {
		$.extend(y, {
			selected : h.attr("selectedId"),
			border : h.attr("border") == "true",
			contextMenu : h.attr("hasMenu") ? h.attr("hasMenu") == "true"
					: undefined,
			isHaveNavigate : h.attr("isHaveNavigate") ? h
					.attr("isHaveNavigate") == "true" : undefined
		})
	}
	function J() {
		f();
		var Q = $.extend(y, r || {});
		top.pageloading = false;
		j = h.tabs(Q);
		P = true;
		L().disableEvent = true;
		if (Q.selected && t(Q.selected)) {
			c(Q.selected)
		} else {
			c(0)
		}
		L().disableEvent = false
	}
	function x(V, U, R, S) {
		if (!T.id && T.id != 0) {
			alert("tab id is required!");
			return
		}
		var T = S || {};
		T.id = V;
		T.title = U;
		T.url = R;
		var Q = t(T.id);
		if (Q) {
			c(T.id);
			if (Q && T.refresh) {
				o(T.id)
			}
		} else {
			d(T)
		}
	}
	function d(T) {
		if (top.pageloading) {
			return false
		}
		if (typeof T == "object" && !T.id) {
			alert("tab id is required!");
			return
		}
		if (t(T.id)) {
			c(T.id);
			return
		}
		var S = null;
		if (T.url) {
			S = '<div class="tabcontent-iframe" style="display:none" url="'
					+ T.url + '"></div>'
		} else {
			S = T.content || "&nbsp;"
		}
		var R = {
			title : "" + T.id,
			desc : T.title || "New Tab " + z++,
			content : S,
			iconCls : T.iconCls,
			closable : u(T.closable),
			history : T.history || new Array(),
			rootId : T._rootName,
			isComplete : false,
			ticket : T.ticket,
			isHaveNavigate : typeof (T.isHaveNavigate) == "undefined" ? true
					: T.isHaveNavigate
		};
		var Q = $.extend({
			onCloseClick : function(U) {
				var V = U.panel("options");
				if (_tabset_onBeforeClose(j, V.title, V.desc) == false) {
					return false
				} else {
					return true
				}
			}
		}, R);
		L().disableEvent = true;
		j.tabs("add", Q);
		L().disableEvent = false
	}
	this.init = function(S) {
		L().init = false;
		var Q = null;
		for (var R = 0; R < S.length; R++) {
			if (S[R].selected) {
				Q = S[R].id
			}
			this.add(S[R])
		}
		c(Q);
		L().init = true
	};
	this.options = L;
	this.add = d;
	this.select = c;
	this.isExist = t;
	this.setEnable = v;
	this.setIconCls = l;
	this.setTitle = O;
	this.setClosable = k;
	this.getTitle = b;
	this.getSelected = w;
	this.getSelectedIndex = s;
	this.getSelectedId = K;
	this.getTab = M;
	this.getTabIndex = m;
	this.close = F;
	this.closeAll = I;
	this.closeOther = N;
	this.closeRight = C;
	this.closeLeft = n;
	this.refresh = o;
	this.setContextMenu = D;
	this.setParams = p;
	this.addParams = A;
	this.openTab = x;
	this.id = h.attr("id");
	this.setActiveTabIndex = c;
	this.setActiveTab = c;
	DynamicTabSet._array[a] = this
}
function _lazyInitTabUrl(g, d, c, h, f, a) {
	var b = function() {
		_initTabUrl(g, d, c, h, f, a)
	};
	var e = setTimeout(b, 200);
	return e
}
function _initTabUrl(m, n, h, e, c, o) {
	var g = m.find("div.tabcontent-iframe");
	var j = g.size() == 0;
	if (!j) {
		var f = "_frame_" + e + "_" + guidGenerator();
		var d = getUrl(g.attr("url"));
		var l = unwrapUrl(d);
		var i = wrapUrl(l[0], $.extend({}, n, l[1], h));
		_topmask();
		g
				.after('<iframe id="'
						+ f
						+ '" scrolling="auto" frameborder="0" src="'
						+ i
						+ '" url="'
						+ i
						+ '" style="width:100%;height:100%;" onload="if(!contentWindow._topmask){_topmask(0);};eval(\'contentWindow.'
						+ o
						+ "=parent."
						+ o
						+ ";');\" onfocus=\"if(typeof(focusFrame) == 'function'){focusFrame();}\"></iframe>");
		g.remove()
	} else {
		var b = m.find("iframe");
		var a = b.attr("src");
		var d = b.attr("url");
		if (e != c) {
			var k = a;
			var l = unwrapUrl(d);
			var p = wrapUrl(l[0], $.extend({}, n, l[1], h));
			if (p != k) {
				ifr.attr("src", p);
				ifr.attr("url", p);
				ifr.attr("reload", "true")
			}
		}
	}
	g = null;
	m = null;
	n = null;
	h = null
}
DynamicTabSet._array = {};
DynamicTabSet.get = function(a) {
	if (window == window.top) {
		return DynamicTabSet._array[a]
	}
	if (DynamicTabSet._array[a]) {
		return DynamicTabSet._array[a]
	} else {
		return parent.DynamicTabSet.get(a)
	}
};
function getUrl(a) {
	if (a.indexOf("http://") == 0) {
	} else {
		if (!a.startWith(_application_root)) {
			a = _application_root + a
		}
	}
	return a
}
function _contextmenu_onfilter(a, d, c) {
	var b = c.title;
	if (d.getSelectedId() == b) {
		a.find('[name="menuitem_refresh"]').removeClass("menu-item-disabled")
	} else {
		a.find('[name="menuitem_refresh"]').addClass("menu-item-disabled")
	}
	if (b == "home") {
		a.find('[name="menuitem_close"]').addClass("menu-item-disabled")
	} else {
		a.find('[name="menuitem_close"]').removeClass("menu-item-disabled")
	}
}
function _tabset_onBeforeClose(a, c, b) {
	if (c == "home") {
		return false
	}
}
function tabNavigate(i, b) {
	if (parent.dts) {
		var h = new Object();
		h.title = i;
		var a = b.indexOf(_application_root);
		h.url = b.substring(a);
		var d = parent.dts;
		try {
			if (d.getSelectedIndex() == 0) {
				return
			}
			var c = d.getSelected().panel("options");
			var g = c.history;
			h.desc = c.desc;
			g.push(h);
			sortPath(g);
			c.isComplete = true
		} catch (f) {
		}
	}
}
function sortPath(d) {
	var a = d.length;
	for (var c = a - 1; c > 0; c--) {
		for (var b = a - 2; b >= 0; b--) {
			if (d[c].title == d[b].title && c != b) {
				d.splice(b + 1, a - b - 1);
				return d
			}
		}
	}
}
var KEYCODE = {
	ENTER : 13,
	ESC : 27,
	END : 35,
	HOME : 36,
	SHIFT : 16,
	TAB : 9,
	LEFT : 37,
	RIGHT : 39,
	UP : 38,
	DOWN : 40,
	DELETE : 46,
	BACKSPACE : 8
};
var easyMsg = {
	_boxId : "#alertMsgBox",
	_bgId : "#alertBackground",
	_closeTimer : null,
	_opentime : 0,
	_types : {
		error : "error",
		info : "info",
		warn : "warn",
		correct : "correct",
		confirm : "confirm"
	},
	frag : {
		alertBoxFrag : '<iframe id="alertBackground" style="z-index:1000;position:absolute;display:none;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);border-style:none;" src="about:blank" class="alert"></iframe><div id="alertMsgBox" class="alert"><div class="alertContent"><div class="#type#"><div class="alertInner"><h1>#title#</h1><div class="msg">#message#</div></div><div class="toolBar">#butFragment#</div></div></div><div class="alertFooter"><div class="alertFooter_r"><div class="alertFooter_c"></div></div></div></div> ',
		alertButFrag : '<a class="easyui-linkbutton" iconCls="#btnIcon#" rel="#callback#" onclick="easyMsg.close();return false;" href="javascript:void(0);"><span>#butMsg#</span></a> '
	},
	_getTitle : function(a) {
		return $.regional.alertMsg.title[a]
	},
	_keydownOk : function(a) {
		if (a.keyCode == KEYCODE.ENTER) {
			a.data.target.trigger("click");
			return false
		}
	},
	_keydownEsc : function(a) {
		if (a.keyCode == KEYCODE.ESC) {
			a.data.target.trigger("click")
		}
	},
	_open : function(k, c, j, p) {
		var e = new Date().getTime();
		var m = this._opentime;
		this._opentime = e;
		if (e - m < 100 && $(this._boxId).has("." + k)) {
			var a = $(this._boxId).find(".msg");
			if ($.browser.mozilla) {
				a
						.html(a.html() + "<br/>"
								+ ("" + c).replace(/\n|\r/g, "<br/>"))
			} else {
				a[0].innerText = a[0].innerText + "\n\r" + c
			}
			return
		}
		$(this._boxId).remove();
		var d = "";
		if (j) {
			for (var f = 0; f < j.length; f++) {
				var o = j[f].call ? "callback" : "";
				d += this.frag.alertButFrag.replace("#butMsg#", j[f].name)
						.replace("#callback#", o).replace("#btnIcon#",
								j[f].btnIcon)
			}
		}
		var l = this.frag.alertBoxFrag.replace("#type#", k).replace("#title#",
				p.title ? p.title : this._getTitle(k)).replace("#butFragment#",
				d);
		var g = $(l).appendTo("body").css({
			top : -$(this._boxId).height() + "px"
		}).animate({
			top : "0px"
		}, 500);
		$(this._bgId).width($(this._boxId).width());
		$(this._bgId).height($(this._boxId).height());
		$(this._bgId).css({
			top : -$(this._boxId).height() + "px"
		}).animate({
			top : "0px"
		}, 500);
		$(this._bgId).show();
		if ($.browser.mozilla) {
			$(this._boxId).find(".msg").html(
					("" + c).replace(/\n|\r/g, "<br/>"))
		} else {
			$(this._boxId).find(".msg")[0].innerText = c
		}
		$.parser.parse(g);
		if (this._closeTimer) {
			clearTimeout(this._closeTimer);
			this._closeTimer = null
		}
		if (this._types.info == k || this._types.correct == k) {
		} else {
			$(this._bgId).show()
		}
		$(
				'<input type="text" style="width:0;height:0;" name="_alertFocusCtr"/>')
				.appendTo(this._boxId).focus().hide();
		var h = $(this._boxId).find("a.easyui-linkbutton");
		var n = h.filter("[rel=callback]");
		var b = $(document);
		for (var f = 0; f < j.length; f++) {
			if (j[f].call) {
				n.eq(f).click(j[f].call)
			}
		}
	},
	close : function() {
		$(this._boxId).animate({
			top : -$(this._boxId).height()
		}, 500, function() {
			$(this).remove()
		});
		$(this._bgId).animate({
			top : -$(this._bgId).height()
		}, 500, function() {
			$(this).remove()
		})
	},
	error : function(b, a) {
		this._alert(this._types.error, b, a)
	},
	info : function(b, a) {
		this._alert(this._types.info, b, a)
	},
	warn : function(b, a) {
		this._alert(this._types.warn, b, a)
	},
	correct : function(b, a) {
		this._alert(this._types.correct, b, a)
	},
	_alert : function(b, d, a) {
		var e = {
			okName : $.regional.alertMsg.butMsg.ok,
			okCall : null
		};
		$.extend(e, a);
		var c = [ {
			name : e.okName,
			call : e.okCall,
			keyCode : KEYCODE.ENTER,
			btnIcon : "icon-ok"
		} ];
		this._open(b, d, c, e)
	},
	confirm : function(e, d, a, b) {
		var f = {
			okName : $.regional.alertMsg.butMsg.ok,
			okCall : d,
			cancelName : $.regional.alertMsg.butMsg.cancel,
			cancelCall : a
		};
		$.extend(f, b);
		var c = [ {
			name : f.okName,
			call : f.okCall,
			keyCode : KEYCODE.ENTER,
			btnIcon : "icon-ok"
		}, {
			name : f.cancelName,
			call : f.cancelCall,
			keyCode : KEYCODE.ESC,
			btnIcon : "icon-cancel"
		} ];
		this._open(this._types.confirm, e, c, f)
	}
};
(function(a) {
	a.setRegional = function(b, c) {
		if (!a.regional) {
			a.regional = {}
		}
		a.regional[b] = c
	};
	a.setRegional("alertMsg", {
		title : {
			error : a.messager.defaults.error,
			info : a.messager.defaults.info,
			warn : a.messager.defaults.warn,
			correct : a.messager.defaults.correct,
			confirm : a.messager.defaults.confirm
		},
		butMsg : {
			ok : a.messager.defaults.ok,
			yes : a.messager.defaults.yes,
			no : a.messager.defaults.no,
			cancel : a.messager.defaults.cancel
		}
	})
})(jQuery);
(function(b) {
	function c(i, g) {
		var d = b.data(i, "popselect");
		var f = d.options;
		if (!g) {
			var e = b.data(i, "combo").combo.find("span.combo-arrow");
			var h = b.data(i, "combo").combo.find("input.combo-text");
			e.add(h).unbind("click.combo").bind("click.combo", function() {
				if (d.dialog.is(":visible")) {
					d.dialog.dialog("close")
				} else {
					if (f.onShowPanel.call(i) == false) {
						return
					}
					d.dialog.dialog("open");
					var j = d.dialog.find("iframe");
					if (j[0] && !j.hasClass("popselect-f-loaded")) {
						j[0].contentWindow.location.href = f.url;
						j.addClass("popselect-f-loaded");
						d.dialog.dialog("maximize")
					}
				}
			})
		}
	}
	function a(g) {
		var d = b.data(g, "popselect");
		var e = d.options;
		b(g).addClass("popselect-f");
		b(g).combo(b.extend({}, e, {}));
		b(g).combo("textbox").parent().addClass("popselect");
		c(g, false);
		if (!d.dialog) {
			d.dialog = b("<div></div>").insertAfter(g);
			var f = b('<iframe scrolling="auto" frameborder="0" style="width:100%;height:100%;"></iframe>');
			d.dialog.append(f);
			d.dialog.attr("title", e.title || "Select Dialog");
			d.dialog.dialog({
				width : 500,
				height : 300,
				maximizable : true,
				collapsible : false,
				modal : true,
				resizable : true,
				closed : true,
				buttons : [ {
					text : "Ok",
					iconCls : "icon-ok",
					handler : function() {
						var i = null;
						var h = f[0];
						if (h.contentWindow.dropDown_onGetRecord) {
							i = h.contentWindow.dropDown_onGetRecord()
						}
						if (e.onSelect.call(g, i) == false) {
							d.dialog.dialog("close");
							return
						}
						d.dialog.dialog("close");
						b(g).combo("textbox").focus()
					}
				}, {
					text : "Cancel",
					iconCls : "icon-cancel",
					handler : function() {
						var i = f[0];
						var h;
						if (i.contentWindow.dropDown_onCanelRecord) {
							h = i.contentWindow.dropDown_onCanelRecord()
						}
						if (e.onCancel.call(g, h) == false) {
							return
						}
						d.dialog.dialog("close")
					}
				} ]
			});
			if (b.data(d.dialog[0], "window").mask) {
				b.data(d.dialog[0], "window").mask.click(function() {
					d.dialog.dialog("close")
				})
			}
		}
	}
	b.fn.popselect = function(d, f) {
		if (typeof d == "string") {
			var e = b.fn.popselect.methods[d];
			if (e) {
				return e(this, f)
			} else {
				return this.combo(d, f)
			}
		}
		d = d || {};
		return this.each(function() {
			var g = b.data(this, "popselect");
			if (g) {
				b.extend(g.options, d)
			} else {
				g = b.data(this, "popselect", {
					options : b.extend({}, b.fn.popselect.defaults,
							b.fn.popselect.parseOptions(this), d)
				})
			}
			a(this)
		})
	};
	b.fn.popselect.methods = {
		options : function(d) {
			return b.data(d[0], "popselect").options
		},
		getData : function(d) {
			return b.data(d[0], "popselect").data
		},
		setValues : function(e, d) {
			return e.each(function() {
				setValues(this, d)
			})
		},
		showPanel : function(d) {
			b.data(d[0], "combo").combo.find("span.combo-arrow").trigger(
					"click.combo")
		},
		setValue : function(e, d) {
			return e.each(function() {
				b(e).combo("setValue", d).combo("setText", d)
			})
		},
		disable : function(d) {
			return d.each(function() {
				b(d).combo("disable");
				c(this, true)
			})
		},
		enable : function(d) {
			return d.each(function() {
				b(d).combo("enable");
				c(this, false)
			})
		}
	};
	b.fn.popselect.parseOptions = function(e) {
		var d = b(e);
		return b.extend({}, b.fn.combo.parseOptions(e), {
			valueField : d.attr("valueField"),
			textField : d.attr("textField"),
			mode : d.attr("mode"),
			method : (d.attr("method") ? d.attr("method") : undefined),
			url : d.attr("url")
		})
	};
	b.fn.popselect.defaults = b.extend({}, b.fn.combo.defaults, {
		valueField : "value",
		textField : "text",
		url : "",
		keyHandler : {
			up : function() {
			},
			down : function() {
			},
			enter : function() {
			},
			query : function(d) {
			}
		},
		formatter : function(e) {
			var d = b(this).popselect("options");
			return e[d.textField]
		},
		onShowPanel : function() {
		},
		onSelect : function(d) {
		},
		onCancel : function(d) {
		}
	})
})(jQuery);
(function(b) {
	function e(l) {
		b(l).addClass("portal");
		var j = b(
				'<table border="0" cellspacing="0" cellpadding="0"><tr></tr></table>')
				.appendTo(l);
		var k = j.find("tr");
		var g = [];
		var f = 0;
		b(l).children("div:first").addClass("portal-column-left");
		b(l).children("div:last").addClass("portal-column-right");
		b(l).find(">div").each(function() {
			var i = b(this);
			f += i.outerWidth();
			g.push(i.outerWidth());
			var m = b('<td class="portal-column-td"></td>').appendTo(k);
			i.addClass("portal-column").appendTo(m);
			i.find(">div").each(function() {
				var n = b(this).addClass("portal-p").panel({
					doSize : false,
					cls : "portal-panel",
					draggable : b(this).attr("draggable")
				});
				c(l, n)
			})
		});
		for (var h = 0; h < g.length; h++) {
			g[h] /= f
		}
		b(l).bind("_resize", function() {
			var i = b.data(l, "portal").options;
			if (i.fit == true) {
				d(l)
			}
			return false
		});
		return g
	}
	function d(m) {
		var q = b(m);
		var f = b.data(m, "portal").options;
		if (f.fit) {
			var h = q.parent();
			f.width = h.width();
			f.height = h.height()
		}
		if (!isNaN(f.width)) {
			q._outerWidth(f.width)
		} else {
			q.width("auto")
		}
		if (!isNaN(f.height)) {
			q._outerHeight(f.height)
		} else {
			q.height("auto")
		}
		var o = q.find(">table").outerHeight() > q.height();
		var j = q.width();
		var g = b.data(m, "portal").columnWidths;
		var k = 0;
		for (var l = 0; l < g.length; l++) {
			var h = q.find("div.portal-column:eq(" + l + ")");
			var n = Math.floor(j * g[l]);
			if (l == g.length - 1) {
				n = j - k - (o == true ? 18 : 0)
			}
			h._outerWidth(n);
			k += h.outerWidth();
			h.find("div.portal-p").panel("resize", {
				width : h.width()
			})
		}
		f.onResize.call(m, f.width, f.height)
	}
	function c(k, g) {
		if (g.panel("options").draggable == false
				|| g.panel("options").draggable == "false") {
			return
		}
		var i;
		g.panel("panel").draggable(
				{
					handle : ">div.panel-header>div.panel-title",
					proxy : function(m) {
						var n = b('<div class="portal-proxy">proxy</div>')
								.insertAfter(m);
						n.width(b(m).width());
						n.height(b(m).height());
						n.html(b(m).html());
						n.find("div.portal-p").removeClass("portal-p");
						return n
					},
					onBeforeDrag : function(m) {
						m.data.startTop = b(this).position().top
								+ b(k).scrollTop()
					},
					onStartDrag : function(m) {
						b(this).hide();
						i = b('<div class="portal-spacer"></div>').insertAfter(
								this);
						l(b(this).outerWidth(), b(this).outerHeight())
					},
					onDrag : function(n) {
						var m = f(n, this);
						if (m) {
							if (m.pos == "up") {
								i.insertBefore(m.target)
							} else {
								i.insertAfter(m.target)
							}
							l(b(m.target).outerWidth())
						} else {
							var o = h(n);
							if (o) {
								if (o.find("div.portal-spacer").length == 0) {
									i.appendTo(o);
									d(k);
									l(o.width())
								}
							}
						}
					},
					onStopDrag : function(o) {
						b(this).css("position", "static");
						b(this).show();
						i.hide();
						b(this).insertAfter(i);
						i.remove();
						d(k);
						g.panel("move");
						var m = b.data(k, "portal").options;
						if (m.cookied) {
							var n = j(k);
							document.cookie = "portal-state-" + _current_user
									+ "=" + n
						}
						m.onStateChange.call(k)
					}
				});
		function j(q) {
			var p = [];
			var r = b(q).find("div.portal-column").size();
			for (var o = 0; o < r; o++) {
				var s = [];
				var m = b(q).portal("getPanels", o);
				for (var n = 0; n < m.length; n++) {
					s.push(m[n].attr("id"))
				}
				p.push(s.join(","))
			}
			return p.join(":")
		}
		function f(o, n) {
			var m = null;
			b(k).find("div.portal-p").each(
					function() {
						var p = b(this).panel("panel");
						if (p[0] != n) {
							var q = p.offset();
							if (o.pageX > q.left
									&& o.pageX < q.left + p.outerWidth()
									&& o.pageY > q.top
									&& o.pageY < q.top + p.outerHeight()) {
								if (o.pageY > q.top + p.outerHeight() / 2) {
									m = {
										target : p,
										pos : "down"
									}
								} else {
									m = {
										target : p,
										pos : "up"
									}
								}
							}
						}
					});
			return m
		}
		function h(n) {
			var m = null;
			b(k).find("div.portal-column").each(function() {
				var o = b(this);
				var p = o.offset();
				if (n.pageX > p.left && n.pageX < p.left + o.outerWidth()) {
					m = o
				}
			});
			return m
		}
		function l(n, m) {
			if (b.boxModel == true) {
				i.width(n - (i.outerWidth() - i.width()));
				if (m) {
					i.height(m - (i.outerHeight() - i.height()))
				}
			} else {
				i.width(n);
				if (m) {
					i.height(m)
				}
			}
		}
	}
	function a(g, h) {
		if (h.link && h.linktext) {
			var f = b("<a/>").css({
				margin : "0px 20px"
			}).attr("href", h.link).text(h.linktext);
			g.prev().find("div.panel-tool").prepend(f)
		}
	}
	b.fn.portal = function(f, g) {
		if (typeof f == "string") {
			return b.fn.portal.methods[f](this, g)
		}
		f = f || {};
		return this.each(function() {
			var h = b.data(this, "portal");
			if (h) {
				b.extend(h.options, f)
			} else {
				h = b.data(this, "portal", {
					options : b.extend({}, b.fn.portal.defaults, b.fn.portal
							.parseOptions(this), f),
					columnWidths : e(this)
				})
			}
			if (h.options.border) {
				b(this).removeClass("portal-noborder")
			} else {
				b(this).addClass("portal-noborder")
			}
			d(this)
		})
	};
	b.fn.portal.methods = {
		options : function(f) {
			return b.data(f[0], "portal").options
		},
		resize : function(g, f) {
			return g.each(function() {
				if (f) {
					var h = b.data(this, "portal").options;
					if (f.width) {
						h.width = f.width
					}
					if (f.height) {
						h.height = f.height
					}
				}
				d(this)
			})
		},
		getColumNum : function(f) {
			return f.find("div.portal-column").size()
		},
		getPanels : function(i, g) {
			var h = i;
			if (g >= 0) {
				h = i.find("div.portal-column:eq(" + g + ")")
			}
			var f = [];
			h.find("div.portal-p").each(function() {
				f.push(b(this))
			});
			return f
		},
		addPanels : function(v, h) {
			var s = {};
			var g = v.portal("getColumNum");
			var m = g <= 0 ? 999999 : g;
			for (var z = 0; z < h.length; z++) {
				h[z].collapsible = h[z].collapsible != false;
				var x = null;
				if (h[z].url) {
					x = '<iframe scrolling="auto" frameborder="0" src="'
							+ getUrl(h[z].url)
							+ '" src1="" style="width:100%;height:100%;padding:0px;margin:0px" ></iframe>'
				} else {
					x = h[z].content || "&nbsp;";
					if (h[z].href) {
						h[z].href = getUrl(h[z].href)
					}
				}
				h[z].content = x;
				h[z].columnIndex = isNumber("" + h[z].columnIndex) ? h[z].columnIndex
						: z % m;
				h[z].rowIndex = isNumber("" + h[z].rowIndex) ? h[z].rowIndex
						: z;
				s["" + h[z].id] = h[z]
			}
			var q = b.data(v[0], "portal").options;
			var l = q.cookied ? v.portal("getState") : null;
			if (l) {
				var f = l.split(":");
				for (var A = 0; A < f.length; A++) {
					var r = f[A].split(",");
					for (var y = 0; y < r.length; y++) {
						var k = s[r[y]];
						if (k) {
							k.columnIndex = A > g - 1 ? g - 1 : A;
							k.rowIndex = y
						}
					}
				}
			}
			function w(i, j) {
				if (i.rowIndex > j.rowIndex) {
					return 1
				}
				if (i.rowIndex < j.rowIndex) {
					return -1
				}
				return 0
			}
			h.sort(w);
			for (var z = 0; z < h.length; z++) {
				var k = h[z];
				var u = b("<div/>").attr("id", k.id).appendTo("body");
				var n = [];
				if (k.refresh) {
					var o = {
						iconCls : "icon-reload",
						handler : function(j) {
							if (b(j).panel("options").url) {
								var p = b(j).find("iframe");
								if (p[0]) {
									p[0].contentWindow.location.reload(true)
								}
								var i = "portal_" + b(j).attr("id")
										+ "_onfresh";
								if (isUserEventDefined(i)) {
									fireUserEvent(i, [ j, p[0] ])
								}
							} else {
								b(j).panel("refresh")
							}
						}
					};
					n.push(o)
				}
				u.panel(b.extend(k, {
					tools : n
				}));
				v.portal("add", {
					panel : u,
					columnIndex : k.columnIndex
				})
			}
			v.portal("resize")
		},
		add : function(g, f) {
			return g.each(function() {
				var i = b(this).find(
						"div.portal-column:eq(" + f.columnIndex + ")");
				var h = f.panel.addClass("portal-p");
				h.panel("panel").addClass("portal-panel").appendTo(i);
				c(this, h);
				h.panel("resize", {
					width : i.width()
				})
			})
		},
		getState : function(k) {
			var h = b.data(k[0], "portal").options;
			var g = document.cookie.split(";");
			if (!g.length) {
				return ""
			}
			for (var f = 0; f < g.length; f++) {
				var j = g[f].split("=");
				if (b.trim(j[0]) == "portal-state-" + _current_user) {
					return b.trim(j[1])
				}
			}
			return ""
		},
		remove : function(g, f) {
			return g.each(function() {
				var h = b(this).portal("getPanels");
				for (var j = 0; j < h.length; j++) {
					var k = h[j];
					if (k[0] == b(f)[0]) {
						k.panel("destroy")
					}
				}
			})
		},
		disableDragging : function(g, f) {
			f.panel("panel").draggable("disable");
			return g
		},
		enableDragging : function(g, f) {
			f.panel("panel").draggable("enable");
			return g
		},
		addToolbar : function(k, i) {
			var j = i[0];
			var h = i[1];
			var g = i[2];
			var f = b("<a/>").css({
				margin : "0px 20px"
			}).attr("href", g).text(h);
			k.find("div[id='" + j + "']").prev().find("div.panel-tool")
					.prepend(f)
		}
	};
	b.fn.portal.parseOptions = function(g) {
		var f = b(g);
		return {
			width : (parseInt(g.style.width) || undefined),
			height : (parseInt(g.style.height) || undefined),
			border : (f.attr("border") ? f.attr("border") == "true" : undefined),
			fit : (f.attr("fit") ? f.attr("fit") == "true" : undefined),
			refresh : (f.attr("refresh") ? f.attr("refresh") == "true" : false),
			cookied : (f.attr("cookied") ? f.attr("cookied") == "true"
					: undefined)
		}
	};
	b.fn.portal.defaults = {
		width : "auto",
		height : "auto",
		border : true,
		fit : false,
		refresh : false,
		cookied : false,
		onResize : function(g, f) {
		},
		onStateChange : function() {
		}
	}
})(jQuery);
(function(g, i, d) {
	var a = "placeholder" in i.createElement("input"), e = "placeholder" in i
			.createElement("textarea"), j = d.fn, c = d.valHooks, l, k;
	if (a && e) {
		k = j.placeholder = function() {
			return this
		};
		k.input = k.textarea = true
	} else {
		k = j.placeholder = function() {
			var m = this;
			m.filter((a ? "textarea" : ":input") + "[placeholder]").not(
					".placeholder").bind({
				"focus.placeholder" : b,
				"blur.placeholder" : f
			}).data("placeholder-enabled", true).trigger("blur.placeholder");
			return m
		};
		k.input = a;
		k.textarea = e;
		l = {
			get : function(n) {
				var m = d(n);
				return m.data("placeholder-enabled")
						&& m.hasClass("placeholder") ? "" : n.value
			},
			set : function(n, o) {
				var m = d(n);
				if (!m.data("placeholder-enabled")) {
					return n.value = o
				}
				if (o == "") {
					n.value = o;
					if (n != i.activeElement) {
						f.call(n)
					}
				} else {
					if (m.hasClass("placeholder")) {
						b.call(n, true, o) || (n.value = o)
					} else {
						n.value = o
					}
				}
				return m
			}
		};
		a || (c.input = l);
		e || (c.textarea = l);
		d(function() {
			d(i).delegate("form", "submit.placeholder", function() {
				var m = d(".placeholder", this).each(b);
				setTimeout(function() {
					m.each(f)
				}, 10)
			})
		});
		d(g).bind("beforeunload.placeholder", function() {
			d(".placeholder").each(function() {
				this.value = ""
			})
		})
	}
	function h(n) {
		var m = {}, o = /^jQuery\d+$/;
		d.each(n.attributes, function(q, p) {
			if (p.specified && !o.test(p.name)) {
				m[p.name] = p.value
			}
		});
		return m
	}
	function b(n, o) {
		var m = this, p = d(m);
		if (m.value == p.attr("placeholder") && p.hasClass("placeholder")) {
			if (p.data("placeholder-password")) {
				p = p.hide().next().show().attr("id",
						p.removeAttr("id").data("placeholder-id"));
				if (n === true) {
					return p[0].value = o
				}
				p.focus()
			} else {
				m.value = "";
				p.removeClass("placeholder");
				m == i.activeElement && m.select()
			}
		}
	}
	function f() {
		var r, m = this, q = d(m), n = q, p = this.id;
		if (m.value == "") {
			if (m.type == "password") {
				if (!q.data("placeholder-textinput")) {
					try {
						r = q.clone().attr({
							type : "text"
						})
					} catch (o) {
						r = d("<input>").attr(d.extend(h(this), {
							type : "text"
						}))
					}
					r.removeAttr("name").data({
						"placeholder-password" : true,
						"placeholder-id" : p
					}).bind("focus.placeholder", b);
					q.data({
						"placeholder-textinput" : r,
						"placeholder-id" : p
					}).before(r)
				}
				q = q.removeAttr("id").hide().prev().attr("id", p).show()
			}
			q.addClass("placeholder");
			q[0].value = q.attr("placeholder")
		} else {
			q.removeClass("placeholder")
		}
	}
}(this, document, jQuery));
function AccordionMenu(target) {
	var _target = $(target);
	var _select = _target.attr("selectedId");
	var _asyc = _target.attr("aysc") == "true";
	var _dataset = null;
	var dataset = null;
	var defaults = {
		loadtype : 1,
		viewField : "_text"
	};
	function _parseAttr() {
		$.extend(defaults, {
			datasetName : _target.attr("componentdataset"),
			contextmenu : _target.attr("contextmenu")
		})
	}
	function _init() {
		_target.accordion({
			animate : !$.mise6,
			onSelect : function(title, index, _id) {
				if (_asyc) {
				}
			}
		});
		_parseAttr();
		var opts = defaults;
		var datasetName = opts.datasetName;
		_dataset = getDatasetByID(datasetName);
		_dataset.init = false;
		var contextmenu = opts.contextmenu;
		dataset = copyDataset(datasetName + new Date().getTime(), datasetName);
		dataset.flushData(1);
		var json = treedataset2json(dataset, opts);
		_load(json)
	}
	_init();
	function _add(obj) {
		var _p = _target.accordion("add", {
			title : obj.text,
			id : obj.id,
			selected : _select == obj.id,
			iconCls : obj.iconCls
		});
		if (obj.children.length > 0) {
			_addtree(_p, obj.children)
		}
	}
	function _addtree(jq, arr) {
		var panels = $.data(jq[0], "accordion").panels;
		$("<ul/>").tree(
				{
					data : arr,
					onClick : function(node) {
						fireUserEvent(_target.attr("id") + "_onClick", [
								node.attributes.record, node ])
					}
				}).appendTo(panels[panels.length - 1])
	}
	function _load(json) {
		var _j = json;
		if ($.type(_j) == "string") {
			_j = eval("(" + json + ")")
		}
		if ($.type(_j) == "array") {
			for (var i = 0; i < _j.length; i++) {
				_add(_j[i])
			}
		}
	}
};