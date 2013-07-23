package dalliance.plugin

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

class DallianceController {

    def index() {
        render (view: 'main')
    }

    def loadScripts = {

        def scripts = [
                '/js/spans.js',
                '/js/utils.js',
                '/js/das.js',
                '/js/browser.js',
                '/js/tier.js',
                '/js/sequence-tier.js',
                '/js/feature-tier.js',
                '/js/slider.js',
                '/js/domui.js',
                '/js/karyoscape.js',
                '/js/quant-config.js',
                '/js/track-adder.js',
                '/js/chainset.js',
                '/js/version.js',
                '/js/sha1.js',
                '/js/sample.js',
                '/js/kspace.js',
                '/json/json2.js',
                '/js/bin.js',
                '/js/bigwig.js',
                '/js/bam.js',
                '/js/twoBit.js',
                '/js/thub.js',
                '/jszlib/js/inflate.js',
                '/dalliance.js'
        ]

        JSONObject result = new JSONObject()
        JSONArray rows = new JSONArray()

        for (file in scripts) {

            JSONObject aScript = new JSONObject()
            aScript.put('path', servletContext.contextPath+pluginContextPath+file)
            aScript.put('type', 'script')
            rows.put(aScript)
        }

        result.put('success', true)
        result.put('totalCount', scripts.size())
        result.put('files', rows)

        response.setContentType('text/json')
        response.outputStream << result.toString()
    }
}
