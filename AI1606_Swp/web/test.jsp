

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: green">
            GeeksforGeekss
            GeeksforGeekss
            
            GeeksforGeeksS
            
            GeeksforGeeks
        </h1>

        <p>
            
            Click on the buttons below to changes
            the language of the webpage.
            the language of the webpage.
            Click on the buttons below to change
            the language of the webpage.
            the language of the webpage.
            the language of the webpage.
        </p>

        <!-- Define the buttons that will
        change   -->
        <button onclick="changeLanguage('eng')">
            Change to English
            </button>
            <button onclick="changeLanguage('es')">
                Change to Spanishs
            </button>
            <button onclick="changeLanguage('hin')">
                Change to Hindi
            </button>

            <!-- Define the content of the page
            that would -->
            <p id="siteContent">
                Welcome to the GeeksforGeeks Portal!
                You can choose any language using the
                buttons above!
                Welcome to the GeeksforGeeks Portal!
                You can choose any language using the
                buttons above!
                Welcome to the GeeksforGeeks Portal!
                You can choose any language using the
                buttons above!
                buttons above!
                buttons above!
                buttons above!
                buttons above!
                buttons above!
            </p>


            <script>
                // Create a function to change
                // the hash value of the page
                function changeLanguage(lang) {
                    location.hash = lang;
                    location.reload();
                }

                // Define the language reload anchors
                var language = {
                    eng: {
                        welcome: "Welcome to the GeeksforGeeks " +
                                "Portal! You can choose any language " +
                                "using the buttons above!"
                    },
                    es: {
                        welcome: "??Bienvenido al portal GeeksforGeeks! " +
                                "??Puedes elegir cualquier idioma usando " +
                                "los botones de arriba!"
                    },
                    hin: {
                        welcome: "GeeksforGeeks ?????????????????? ?????? ???????????? ?????????????????? ??????! " +
                                "?????? ????????? ????????? ?????? ????????? ?????? ??????????????? ???????????? ???????????? ?????? " +
                                "???????????? ?????? ????????? ???????????? ?????????!"
                    }
                };

                // Check if a hash value exists in the URL
                if (window.location.hash) {

                    // Set the content of the webpage
                    // depending on the hash value
                    if (window.location.hash == "#es") {
                        siteContent.textContent =
                                language.es.welcome;
                    } else if (window.location.hash == "#hin") {
                        siteContent.textContent =
                                language.hin.welcome;
                    }
                }
            </script>

    </body>
</html>
