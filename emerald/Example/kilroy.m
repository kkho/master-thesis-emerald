const Kilroy <- object Kilroy
  process
    const home <- locate self
    var there :     Node
    var startTime, diff : Time
    var all : NodeList
    var theElem :NodeListElement
    var stuff : Real

    home.getstdout.PutString["Starting on " || home.getname || "\n"]
    all <- home.getActiveNodes
    home.getstdout.PutString[(all.upperbound + 1).asString || " nodes active.\n"]
    startTime <- home.getTimeOfDay
    for i : Integer <- 1 while i <= all.upperbound by i <- i + 1
      there <- all[i].gettheNode
      move Kilroy to there
      there.getstdout.PutString["Kilroy was here\n"]
    end for
    move Kilroy to home
    diff <- home.getTimeOfDay - startTime
    home.getstdout.PutString["Back home.  Total time = " || diff.asString || "\n"]
  end process
end Kilroy
