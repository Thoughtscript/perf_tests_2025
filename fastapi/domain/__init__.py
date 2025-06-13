class Example:
  def __init__(self, id, name):
      self.id = id
      self.name = name

async def get_examples():
    result = []
    result.append(Example(1, "a"))
    result.append(Example(2, "b"))
    # Can't return Object List or await a List here
    ## Must use Class
    return result