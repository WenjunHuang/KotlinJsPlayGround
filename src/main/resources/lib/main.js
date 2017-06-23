/**
 * Created by rick on 2017/6/22.
 */
require.config({
    paths: {
        'jquery': 'jquery.slim',
        'kotlin': 'kotlin',
        'app': 'KotlinJsPlayGround_main'
    }
});

require(['jquery', "KotlinJsPlayGround_main"], function ($, example) {
    $(function () {
            example.simpleflux.Main.run();
        }
    );
});
