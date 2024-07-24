scoreboard players set @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] pipe_sound 15
scoreboard players set @e[type=minecraft:area_effect_cloud,tag=Marker] _age 1
summon minecraft:area_effect_cloud ~ ~ ~ {"Tags":["Marker"],"Duration":-1,"Age":-2147483648,"WaitTime":-2147483648}
scoreboard players add @e[type=minecraft:area_effect_cloud,tag=Marker] _age 1
scoreboard players add Global _unique 1
execute unless score @e[type=minecraft:area_effect_cloud,tag=Marker,limit=1,scores={_age=1}] _id matches 1.. run scoreboard players operation @e[type=minecraft:area_effect_cloud,tag=Marker,limit=1,scores={_age=1}] _id = Global _unique
execute store result score @s travel run scoreboard players get @e[type=minecraft:area_effect_cloud,tag=Marker,limit=1,scores={_age=1}] _id
scoreboard players operation Global _id = @s travel
execute as @e if score @s _id = Global _id run function glass_pipes:execute070_ln225