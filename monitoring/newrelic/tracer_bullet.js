/**
 * New Relic Tracer Bullet Synthetic
 */

var request = require('request');
var assert = require('chai').assert;

/**
 * Performs a GET /romannumeral/?query=[number] request
 * @param int number
 * Expected output:
 *   {"input":5,"output":"V"}
 */
var doRomanNumeralsGet = function(number) {
    console.log('Trying to roman numeral for number: ' + number);
    $http.get({
        url: endpoint + '?query='+number,
        headers: ['User-Agent': 'new relic synthetics']
        },
    }, function(error, response, body) {
        onRomanNumeralsGet(number, error, response, body);
    });
};

/**
 * Handle response for doRomanNumeralsGet
 *
 * @param number
 * @param error
 * @param response
 * @param body
 */
var onRomanNumeralsGet = function(number, error, response, body) {
    var data = JSON.parse(body);
    if (response.statusCode == 400) {
        console.log("Roman numerals API call failed: "+response)
    } else if (response.statusCode == 200) {
        // test response contents
        assert.isObject(data, 'response data is an object');
        assert.property(data, 'input', 'response data has input property');
        assert.property(data, 'output', 'response data has output property');
        console.log('Response received and validated');
    } else {
        console.log(body);
        throw new Error("Unexpected status code '" + response.statusCode + "' while trying to call Roman numerals API");
    }
};

doRomanNumeralsGet(5);