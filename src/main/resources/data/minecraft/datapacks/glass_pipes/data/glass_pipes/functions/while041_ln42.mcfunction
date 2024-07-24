scoreboard players set Global pic_scratch2 1
execute if score Global first matches 1.. run function glass_pipes:execute019_ln43
execute if score Global pic_scratch2 matches 1.. run function glass_pipes:else020_ln43
execute if score Global r matches 0 run execute if score Global dirs0 matches 1.. run function glass_pipes:execute023_ln53
execute if score Global r matches 1..2 run function glass_pipes:switch1-2_024_ln52
execute if score Global r matches 3 run execute if score Global dirs3 matches 1.. run function glass_pipes:execute033_ln53
execute if score Global r matches 4..5 run function glass_pipes:switch4-5_034_ln52
execute if score Global searching matches 1.. run function glass_pipes:while041_ln42