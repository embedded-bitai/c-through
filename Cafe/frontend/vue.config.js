module.exports = {
	publicPath: process.env.NODE_ENV === 'production' ? '/vue-pro-sidebar/' : '/',
	publicPath: process.env.NODE_ENV === 'production' ? '/vue-event-card/' : '/',
	chainWebpack: config => {
	//	process.env.NODE_ENV === 'production' ? config.externals(['@vue/composition-api']):{};
	},
	css: {
		extract: false,
	},
};
