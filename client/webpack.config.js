const webpack = require('webpack');

const CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: {
        polyfill: "./src/polyfill.ts",
        vendor: "./src/vendor.ts",
        app: "./src/main.ts"
    },
    output: {
        path: __dirname + '/dist',
        filename: "[name].js"
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                loaders: ['awesome-typescript-loader', 'angular2-template-loader']
            }, {
                test: /\.(html|css)$/,
                loader: 'raw-loader',
                exclude: 'index.html'
            }
        ]
    },
    plugins: [
        new CommonsChunkPlugin({
            name: ['vendor', 'polyfill']
        }),
        new HtmlWebpackPlugin({
            template: './index.html',
            chunksSortMode: 'dependency'
        }),
        new webpack.NoEmitOnErrorsPlugin()
    ],
    resolve: {
        extensions: [".js", ".ts", '.css', ".html"]
    },
    devtool: 'source-map',

    devServer: {
        proxy: {'/travel/**': 'http://localhost:8080'}
    }
}
