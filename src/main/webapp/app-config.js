/**
 * The script holds the configs for the client Angular module..
 * Configs include :
 *  - Bean injections
 *  - Routing configurations and mappings
 *
 * @type {module}
 */
var yobetitTestApp =
    angular.module('yobetitTestApp', [
        'services',
        'controllers'
    ]);

yobetitTestApp.config(function($httpProvider){

    /**
     *
     * Http interceptors config
     *
     * */
    $httpProvider.interceptors.push(function($rootScope, $q) {
        return {
            /**
             * Interceptor for responseError
             */
            'responseError': function(config) {
                alert('oops something went wrong on the server :( ');
                return config;
            }
        };
    });

});