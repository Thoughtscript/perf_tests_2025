from fastapi import APIRouter
import asyncio
import domain

api = APIRouter()

@api.get("/api/example/all")
async def examples():
    # Asyncio coroutine
    f = asyncio.create_task(domain.get_examples()) # Can't pass Function alone - must call
    # Use await not f.result()
    return await f # Don't wrap with { } for JSON serialization