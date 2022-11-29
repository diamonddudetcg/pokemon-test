# Userlytics Android Developer Test
Hi there! This is the interview test instruction for Android Developer position at Userlytics. Please read the guidance carefully. Best of luck!

## What you will have to do.
- Use Android studio to build the Android application according to the detail described in the application description section.
- Use `git` to track your work history.

**Note**

- Please write the code in a way that demonstrates your current set of skills.
- Please use design pattern and libraries that you think are the best. 
- You are free to do anything to the project to achieve the application described in the application description section.

## Application Desciption: Pokemon Info

This section describes the detail of the application that you will have to build.

### Objective

This application displays the list of Pokemons. The user can click on each item of the list to see the detail of each pokemon.

### Overview

![ezgif-5-882a372cf276](https://user-images.githubusercontent.com/19642082/61866786-0a595c00-af00-11e9-9225-8b4c044dd8ed.gif)

### Screens
This section describes the behavior and detail of each screen. We will discuss about data and api in detail in the next section. 

#### 1. Pokemon List Screen ####
Display paginated list from Pokemon List API(https://pokeapi.co/api/v2/pokemon). When clicking on each item in the list, the Pokemon detail dialog will be shown. Please noted that the URL for fetching pokemon detail will be passed to Pokemon detail dialog from Pokemon List Screen.

![Screen Shot 2019-07-25 at 4 36 42 PM](https://user-images.githubusercontent.com/19642082/61863901-b13af980-aefa-11e9-8a83-f6bb221d6e23.png)

#### 2. Pokemon Detail Dialog ####
This is a dialog for displaying pokemon detail. This dailog show when the item in Pokemon List screen is clicked. There are only 4 field display in this page `base_experience`, `height`, `name`, `weight`.

![Screen Shot 2019-07-25 at 4 41 51 PM](https://user-images.githubusercontent.com/19642082/61864176-29a1ba80-aefb-11e9-9269-07a6c21aa923.png)

### Data

The data in this application is fetch from PokéAPI(https://pokeapi.co)
There are only two endpoints called in this application.

#### 1. Pokemon List API ####
https://pokeapi.co/api/v2/pokemon

Paginated list of Pokemon

Sample response
``` {  
   "count":964,
   "next":"https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
   "previous":null,
   "results":[  
      {  
         "name":"bulbasaur",
         "url":"https://pokeapi.co/api/v2/pokemon/1/"
      },
      {  
         "name":"ivysaur",
         "url":"https://pokeapi.co/api/v2/pokemon/2/"
      },
      {  
         "name":"venusaur",
         "url":"https://pokeapi.co/api/v2/pokemon/3/"
      },
      {  
         "name":"charmander",
         "url":"https://pokeapi.co/api/v2/pokemon/4/"
      },
      {  
         "name":"charmeleon",
         "url":"https://pokeapi.co/api/v2/pokemon/5/"
      }
   ]
}
```

#### 2. Pokemon Detail ####
Use `url` field from item in `results` to get pokemon detail api url.

Please refer to one of the item in `results` of response from the pokemon list endpoint.
```
{  
    "name":"bulbasaur",
    "url":"https://pokeapi.co/api/v2/pokemon/1/"
}
```
Call https://pokeapi.co/api/v2/pokemon/1/ to get pokemon detail

**Sample response**: You only need to map these 4 fields to the model: `base_experience`, `height`, `name`, `weight`

``` 
{  
   "abilities":[...],
   "base_experience":64,
   "forms":[...],
   "game_indices":[...],
   "height":7,
   "held_items":[...],
   "id":1,
   "is_default":true,
   "location_area_encounters":"https://pokeapi.co/api/v2/pokemon/1/encounters",
   "moves":[...],
   "name":"bulbasaur",
   "order":1,
   "species":{...},
   "sprites":{...},
   "stats":[...],
   "types":[...],
   "weight":69
}
```

## Implementation Guide 
- The following are the color code using in the project.
    - `<color name="colorPrimary">#F4B400</color>` 
    - `<color name="colorPrimaryDark">#E19720</color>`
    - `<color name="colorAccent">#F62D14</color>`
- The layout doesn't have to be the same as the screenshots. You can decide the dimension of the layouts based on your judgment.

## Submission

**Please Do** upload this project to the version control system such as GitHub, GitLab, or others and give access to mbaykar@userlytics.com

