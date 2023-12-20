---------------------( Mostar relacion victima - atacante con nombres )--------------------------------

SELECT incident.id,
       CONCAT(attacker_user.firstname, ' ', attacker_user.lastname) AS attacker,
       CONCAT(victim_user.firstname, ' ', victim_user.lastname)     AS victim
FROM incident
         JOIN attacker ON incident.attacker = attacker.id
         JOIN user AS attacker_user ON attacker.user = attacker_user.id
         JOIN victim ON incident.victim = victim.id
         JOIN user AS victim_user ON victim.user = victim_user.id;

---------------------( Mostar ultima ubicacion segun incidente )---------------------------------------

(select *
 from history
 where (history.user IN (select attacker.user
                         from attacker
                         where attacker.id IN (select incident.attacker from incident where incident.id = 1)))
 order by history.id desc limit 1)
UNION
(select *
 from history
 where (history.user IN (select victim.user
                         from victim
                         where victim.id IN (select incident.victim from incident where incident.id = 1)))
 order by history.id desc limit 1)