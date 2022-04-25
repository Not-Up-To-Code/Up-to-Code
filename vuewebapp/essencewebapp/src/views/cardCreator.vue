<template>
<body id="body">
    <div class="grid-container">
        <div id="app">
            <p class="CardType">Card Type</p>
            <p class="CardColor">Card Color</p>
            <select class="CardTypeToolbar" v-model="selected">
                <option disabled value="">Please select one</option>
                <option>Alpha</option>
                <option>Competency</option>
              </select>
              <span class="CardColorToolbar">Selected: {{ selected }}</span>

              <select class="CardColorToolbar" v-model="selected">
                <option disabled value="">Please select one</option>
                <option>Yellow</option>
                <option>Blue</option>
                <option>Green</option>
              </select>
              <span style="color: brown;">Selected: {{ selected }}</span>

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
        
        <div id="header" class="header">
            <h1>
                Essence Kernel Tools
            </h1>
        </div>

        

        <div id="menu" class="menu">
            <a href="index.html">Home</a>
            <a href="practiceCatalog.html">Essence Practice Catalog</a>
            <a href="practiceCreator.html">Create Essence Practice</a>
            <a href="cardCatalog.html">Essence Card Catalog</a>
            <a href="cardCreator.html" class="active">Create Essence Cards</a>
            <p id="menuLabel">Essence games</p>
            <a href="progressPoker.html">Progress Poker</a>
            <a href="chaseTheState.html">Chase the State</a>
            <a href="objectiveGo.html">Objective Go</a>
            <a href="checkpointConstruction.html">Checkpoint Construction</a>
        </div>
        <div id="content" class="content">

        </div>
    </div>
    </div>
</body>
</template>
