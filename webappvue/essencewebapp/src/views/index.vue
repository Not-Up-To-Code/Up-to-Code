
<!DOCTYPE html>
<html lang="en" xmlns:v-bind="http://www.w3.org/1999/xhtml">


<head>
    <meta charset="UTF-8">
    <title>Essence Kernel Tools</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body id="body">

<div id="test">
    <h1>Test {{ testString }}



    </h1>
</div>
<!--
<script type="module">
    new Vue({
        el:"#test",
        data:{
            message: "Vue Testing"
        }
    })
</script>




el:"#test",
        data:{

                string: this.search()
        },
        created(){
            this.search();
        },
        methods: {
            search: function () {
                fetch('http://localhost:7000/')
                    .then(response => response.text())
                    .then(text => {
                        const data1 = text.result;
                        this.string = data1;
                    })


            }
        }
    })
import axios from "axios";
    const BASE_URL = 'http://localhost:7000';

    const getHello = async () => {
        try {
            const response = await axios.get(`${BASE_URL}/`);

            const hello = response.data;

            return hello;
        } catch (errors) {
            console.error(errors);
            const hello = 'loading...';
            return hello;
        }
    };

-->

<script type = "module">


    new Vue({
        el: "#test",
        data() {
            return {
                testString: ''
            };
        },
        created(){
            fetch("http://localhost:7000/")
                .then(response => response.text())
                .then(data => {console.log(data); this.testString = data;})
        },

    });
</script>


<!--
<script type="module">
    new Vue({
        el:"#test",
        data: {
            message: 'test'
        }

    })
</script>
-->

    <div class="grid-container">
        <div id="header" class="header">
            <h1>
                Essence Kernel Tools
            </h1>
        </div>

        <div id="menu" class="menu">
            <a href="index.html" class="active">Home</a>
            <a href="practiceCatalog.html">Essence Practice Catalog</a>
            <a href="practiceCreator.html">Create Essence Practice</a>
            <a href="cardCatalog.html">Essence Card Catalog</a>
            <a href="cardCreator.html">Create Essence Cards</a>
            <p id="menuLabel">Essence games</p>
            <a href="progressPoker.html">Progress Poker</a>
            <a href="chaseTheState.html">Chase the State</a>
            <a href="objectiveGo.html">Objective Go</a>
            <a href="checkpointConstruction.html">Checkpoint Construction</a>
        </div>
        <div id="content" class="content">

        </div>
    </div>
</body>