
---------------------( Mostar relacion victima - atacante con nombres )--------------------------------

SELECT incident.id, 
      CONCAT(attacker_user.firstname, ' ', attacker_user.lastname) AS attacker, 
      CONCAT(victim_user.firstname, ' ', victim_user.lastname) AS victim 
FROM incident 
JOIN attacker ON incident.attacker = attacker.id 
JOIN user AS attacker_user ON attacker.user = attacker_user.id 
JOIN victim ON incident.victim = victim.id 
JOIN user AS victim_user ON victim.user = victim_user.id;