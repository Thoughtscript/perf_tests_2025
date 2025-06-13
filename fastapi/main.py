from fastapi import FastAPI

from router import example_handler

app = FastAPI() 

app.include_router(example_handler.api)
