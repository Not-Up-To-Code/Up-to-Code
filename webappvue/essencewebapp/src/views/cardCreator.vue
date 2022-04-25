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


</style>
