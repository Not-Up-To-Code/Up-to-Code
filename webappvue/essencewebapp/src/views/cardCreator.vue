<template>
<body id="body">
    <div class="grid-container">
        <div id="app" class="header">
            <h1 class="essence">
                Essence Kernel Tools
            </h1>
            <p class="CardType">Card Type</p>
            <p class="CardColor">Card Color</p>
            <select class="CardTypeToolbar" v-model="selected">
                <option disabled value="">Please select one</option>
                <option>Alpha</option>
                <option>Competency</option>
              </select>
              <select class="CardColorToolbar" v-model="selected">
                <option disabled value="">Please select one</option>
                <option>Yellow</option>
                <option>Blue</option>
                <option>Green</option>
              </select>
            <div>
               <button class="ShowStateCards">Show State Cards</button>
            </div>

            <div>
                <button class="ShowAlphaCard">Show Alpha Card</button>
             </div>

             <div>
                <button class="SaveCard">Save Card</button>
             </div>
             <div>
                <button class="UpdateCard">Update Card</button>
                
             </div>
        
        

        

        <div id="menu" class="menu">
            <router-link to="/">Home</router-link> |
            <router-link to="/about">About</router-link>
            <router-link to="/practiceCreator">Create Essence Practice</router-link>
            <router-link to="/cardCatalog">Essence Card Catalog</router-link>
            <router-link to="/cardCreator">Create Essence Cards</router-link>
            <p id="menuLabel">Essence games</p>
            <router-link to="/progressPoker">Progress Poker</router-link>
            <router-link to="/chaseTheState">Chase The State</router-link>
            <router-link to="/objectiveGo">Objective Go</router-link>
            <router-link to="/checkpointConstruction">Checkpoint Construction</router-link>
            <router-link to="/practiceCatalog">Practice Catalog</router-link>
        </div>
        <div id="content" class="content">

        </div>
    </div>
    </div>
    
            <div class="outer">
    <div class="top">Alpha card name </div>
    <input v-model="message" class="alpha" placeholder="Alpha name"/>
    <input v-model="message" class="moove" placeholder="state1"/>
    <input v-model="message" class="moove" placeholder="state2"/>
    <input v-model="message" class="moove" placeholder="state3"/>
    <input v-model="message" class="moove" placeholder="state4"/>
    <input v-model="message" class="moove" placeholder="state5"/>
    <input v-model="message" class="moove" placeholder="state6"/>
    <input v-model="message" class="brief" placeholder="brief description"/>
    <input v-model="message" class="detaildescription" placeholder="detail deescription"/>


   </div>
</body>
</template>
<style>

html{
    margin: 0px;
    padding: 0px;
}

#body{
    margin: 0px;
    padding: 0px;
    background-color: #000E0F;
}

.grid-container{
    display: grid;
    grid-template-columns: 20% 180%;
    grid-template-areas:
    "header content"
    "menu content"
    ;
}

#header{
    grid-area: header;
    background-color: #1B5559;
    color: white;
    text-align: center;
    font-size: 20px;
}
.essence{
    grid-area: header;
    background-color: #1B5559;
    color: white;
    text-align: center;
    font-size: 40px;
}

#menu{
    grid-area: menu;
    background-color: #1B5559;
}

#menu a{
    background-color: #1B5559;
    color: white;
    display: block;
    padding: 12px;
    text-decoration: none;
}

#menu a:hover{
    background-color: #2c7379;
}

#menu a.active{
    background-color: #449ca1;
}

#menuLabel{
    background-color: #000E0F;
    color: white;
    padding: 12px;
}
.vcardtemplate{
    color: red;
    background: white;
    position: absolute;
    bottom: 250px;
    left: 400px;
    margin: 50px;
    display: inline-block;

}
.vcardtemplatetitle{
    background: yellow;

}


.ShowStateCards{
            position: absolute;
            bottom: 70px;
            left: 300px;
            margin: 50px;
            display: inline-block;
        }

        .ShowAlphaCard{
        position: absolute;
        bottom: 70px;
        left: 600px;
        margin: 50px;
        display: inline-block;
    }
    .SaveCard{
        position: absolute;
        bottom: 70px;
        left: 900px;
        margin: 50px;
        display: inline-block;
    }
    .UpdateCard{
        position: absolute;
        bottom: 500px;
        left: 900px;
        margin: 50px;
        display: inline-block;
    }
    .CardTypeToolbar{
        position: absolute;
        bottom: 500px;
        left: 300px;
        margin: 50px;
        display: inline-block;
    }
    .CardColorToolbar{
        position: absolute;
        bottom: 500px;
        left: 600px;
        margin: 50px;
        display: inline-block;
    }
    .CardType{
        color: white;
        position: absolute;
        bottom: 530px;
        left: 320px;
        margin: 50px;
        display: inline-block;
    }
    .CardColor{
        color: white;
        position: absolute;
        bottom: 530px;
        left: 620px;
        margin: 50px;
        display: inline-block;
    }

.alpha{
    display: list-item;
    background: rgb(225, 225, 68);
    border-color: rgb(225, 225, 68);
    position: relative;
    border-radius: 10px;
    width: 30%;
    padding: 10px 20px;
    top:-60px;
    left:10%;

     

}
.moove{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 10px 20px;
    top:0px;
    left:2%;
    margin: 20px;
    bottom: 20px; 
}

.brief{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 50px 20px;
    top:-355px;
    left:50%;
    margin: 20px;
   
}
.detaildescription{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 50px 20px;
    top:-300px;
    left:50%;
    margin: 20px;
    bottom: 70px;
}
div.outer{
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
    overflow: hidden;
    border-color: red;
    background-color: white;
    margin: 0px 200px ;
    padding: 0px 0px;
    height: 550px;
    right: 100px;
}

div.outer .top{
    border-radius: 10px;
    padding: 30px 240px;
    width: 50%;
    background-color: rgb(225, 225, 68);
}



</style>
